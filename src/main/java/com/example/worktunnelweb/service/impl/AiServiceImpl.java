package com.example.worktunnelweb.service.impl;

import com.example.worktunnelweb.dto.UserAiDTO;
import com.example.worktunnelweb.entity.Register;
import com.example.worktunnelweb.entity.UserAi;
import com.example.worktunnelweb.repository.AiRepo;
import com.example.worktunnelweb.repository.RegisterRepo;
import com.example.worktunnelweb.service.AnonymousAiService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AiServiceImpl implements AnonymousAiService {

    private final RegisterRepo registerRepo;
    private final AiRepo aiRepo;




    @Override
    public String promptSave(UserAiDTO userAiDTO) {
        if (userAiDTO.getPromptKeywords() == null || userAiDTO.getPromptKeywords().isEmpty()) {
            throw new IllegalArgumentException("Prompt cannot be null or empty");
        }

        String userPrompt = userAiDTO.getPromptKeywords();


        List<String> keywords = extractKeywords(userPrompt);
        String keywordCSV = String.join(",", keywords);


        String aiResponse = getAIResponse(userPrompt);


        UserAi aiEntity = new UserAi();
        aiEntity.setPromptKeywords(keywordCSV);


        if (userAiDTO.getUserId() != null) {
            Register register = registerRepo.findById(userAiDTO.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            aiEntity.setRegister(register);
        } else {
            aiEntity.setAnonymousUser("Anonymous User");
        }

        aiRepo.save(aiEntity);


        return aiResponse;
    }

    @Override
    public Long getCount() {
        return aiRepo.count();
    }


    private List<String> extractKeywords(String sentence) {
        sentence = sentence.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "");
        String[] words = sentence.split("\\s+");

        Set<String> stopWords = Set.of(
                "i", "need", "for", "the", "is", "a", "an", "under", "to", "of", "and"
        );

        List<String> keywords = new ArrayList<>();
        for (String word : words) {
            if (!stopWords.contains(word) && word.length() > 2) {
                keywords.add(word);
            }
        }
        return keywords;
    }


    private String getAIResponse(String userMessage) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(API_KEY);

        String body = """
    {
      "model": "llama-3.1-8b-instant",
      "messages": [
        {
          "role": "user",
          "content": "%s"
        }
      ]
    }
    """.formatted(userMessage);

        HttpEntity<String> request = new HttpEntity<>(body, headers);

        ResponseEntity<String> response =
                restTemplate.postForEntity(URL, request, String.class);

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.getBody());


            return root
                    .path("choices")
                    .get(0)
                    .path("message")
                    .path("content")
                    .asText();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error parsing AI response";
        }
    }
}
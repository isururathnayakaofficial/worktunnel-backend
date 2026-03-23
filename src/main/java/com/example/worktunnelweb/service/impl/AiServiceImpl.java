package com.example.worktunnelweb.service.impl;

import com.example.worktunnelweb.dto.UserAiDTO;
import com.example.worktunnelweb.entity.Register;
import com.example.worktunnelweb.entity.UserAi;
import com.example.worktunnelweb.repository.AiRepo;
import com.example.worktunnelweb.repository.RegisterRepo;
import com.example.worktunnelweb.service.AnonymousAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AiServiceImpl implements AnonymousAiService {
    private final RegisterRepo registerRepo;
    private final AiRepo aiRepo;




    @Override
    public void promptSave(UserAiDTO userAiDTO) {

        if (userAiDTO.getPromptKeywords() == null || userAiDTO.getPromptKeywords().isEmpty()) {
            throw new IllegalArgumentException("Prompt keywords cannot be null or empty");
        }

        String sentence = userAiDTO.getPromptKeywords();

        // Convert to lowercase
        sentence = sentence.toLowerCase();

        // Remove special characters
        sentence = sentence.replaceAll("[^a-zA-Z0-9 ]", "");

        // Split into words
        String[] words = sentence.split("\\s+");

        // Stop words list
        Set<String> stopWords = Set.of(
                "i", "need", "for", "the", "is", "a", "an", "under", "to", "of", "and"
        );

        // Extract keywords
        List<String> keywords = new ArrayList<>();

        for (String word : words) {
            if (!stopWords.contains(word) && word.length() > 2) {
                keywords.add(word);
            }
        }

        // Convert to CSV
        String keywordCSV = String.join(",", keywords);

        // Create entity
        UserAi aiEntity = new UserAi();
        aiEntity.setPromptKeywords(keywordCSV);

        // Handle user / anonymous
        if (userAiDTO.getUserId() != null) {

            Register register = registerRepo.findById(userAiDTO.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            aiEntity.setRegister(register);

        } else {
            //  Anonymous user case
            aiEntity.setAnonymousUser("Anonymous User"); //
        }

        aiRepo.save(aiEntity);
    }
    }




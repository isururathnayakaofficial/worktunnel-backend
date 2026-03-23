package com.example.worktunnelweb.service.impl;

import com.example.worktunnelweb.dto.AnonymousAiDTO;
import com.example.worktunnelweb.dto.UserAiDTO;
import com.example.worktunnelweb.entity.UserAi;
import com.example.worktunnelweb.repository.AiRepo;
import com.example.worktunnelweb.service.AnonymousAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AiServiceImpl implements AnonymousAiService {
    private final AiRepo anonymousAiRepo;
    @Override
    public void saveSearchResult() {


    }

    @Override
    public void keywordFilter(AnonymousAiDTO aiDTO) {



    }

    @Override
    public void promptSave(UserAiDTO userAiDTO) {
        String sentence = userAiDTO.getPromptKeywords();
        int userId=userAiDTO.getUserId();

        //Convert to lowercase
        sentence = sentence.toLowerCase();

        //Remove special characters
        sentence = sentence.replaceAll("[^a-zA-Z0-9 ]", "");

        //Split into words
        String[] words = sentence.split("\\s+");

        //Stop words list
        Set<String> stopWords = Set.of(
                "i", "need", "for", "the", "is", "a", "an", "under", "to", "of", "and"
        );

        // Extract keywords (maintain order)
        List<String> keywords = new ArrayList<>();

        for (String word : words) {
            if (!stopWords.contains(word) && word.length() > 2) {
                keywords.add(word);
            }
        }

        // Convert to comma-separated string
        String keywordCSV = String.join(",", keywords);

        // Save (example)
        UserAi aiEntity = new UserAi();
        aiEntity.setPromptKeywords(keywordCSV);
        aiEntity.setUserId(userId);
    }


}

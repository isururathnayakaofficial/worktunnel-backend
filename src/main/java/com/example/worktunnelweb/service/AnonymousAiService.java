package com.example.worktunnelweb.service;

import com.example.worktunnelweb.dto.AnonymousAiDTO;

public interface AnonymousAiService {
    void saveSearchResult();
    void keywordFilter(AnonymousAiDTO aiDTO);
}

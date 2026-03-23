package com.example.worktunnelweb.service;

import com.example.worktunnelweb.dto.AnonymousAiDTO;
import com.example.worktunnelweb.dto.UserAiDTO;

public interface AnonymousAiService {
    void saveSearchResult();
    void keywordFilter(AnonymousAiDTO aiDTO);
    void promptSave(UserAiDTO userAiDTO);
}

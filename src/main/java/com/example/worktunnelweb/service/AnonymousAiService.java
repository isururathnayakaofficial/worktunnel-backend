package com.example.worktunnelweb.service;

import com.example.worktunnelweb.dto.UserAiDTO;

public interface AnonymousAiService {

    String promptSave(UserAiDTO userAiDTO);
    Long getCount();
}

package com.example.worktunnelweb.dto;

import lombok.Data;

@Data
public class UserAiDTO {
    public String userId;
    public String promptKeywords;
    private String anonymousUser;
}

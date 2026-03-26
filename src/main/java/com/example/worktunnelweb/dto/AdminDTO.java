package com.example.worktunnelweb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {
    private String adminName;
    private String email;
    private String contact;
    private String password;
    private String roleName;
}

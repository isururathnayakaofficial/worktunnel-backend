package com.example.worktunnelweb.dto;

import lombok.Data;

import javax.management.relation.Role;

@Data
public class SuperAdminDTO {
    private String adminName;
    private String email;
    private String contact;
    private String roleName;
}

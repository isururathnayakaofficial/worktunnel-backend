package com.example.worktunnelweb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import javax.management.relation.Role;

@Entity
@Data
public class Admin {
    @Id
    private int id;
    private String adminName;
    private String email;
    private String contact;
    private String password;
    private String roleName;
}

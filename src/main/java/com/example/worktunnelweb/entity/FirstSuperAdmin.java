package com.example.worktunnelweb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FirstSuperAdmin {
    @Id
    private int id;
    private String username;
    private String password;
}

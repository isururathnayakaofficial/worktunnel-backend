package com.example.worktunnelweb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class FirstSuperAdmin {
    @Id
    private int id;
    private String username;
    private String password;
}

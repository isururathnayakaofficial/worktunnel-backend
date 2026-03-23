package com.example.worktunnelweb.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserAi {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @ManyToOne
    public Register userId;
    public String promptKeywords;
}

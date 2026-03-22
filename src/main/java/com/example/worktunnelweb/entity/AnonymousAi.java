package com.example.worktunnelweb.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AnonymousAi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "keywords")
    private String searchResult;
}

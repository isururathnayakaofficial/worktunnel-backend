package com.example.worktunnelweb.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchConnectionDetails;
@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

}
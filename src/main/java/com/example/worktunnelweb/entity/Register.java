package com.example.worktunnelweb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String profession;
    private String password;
    private int age;



    public Register(String name, String email, String profession, String password, int age) {
        this.name = name;
        this.email = email;
        this.profession = profession;
        this.password = password;
        this.age = age;
    }
}

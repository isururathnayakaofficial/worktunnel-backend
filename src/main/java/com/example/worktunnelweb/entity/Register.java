package com.example.worktunnelweb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private String email;
    private String profession;
    private String password;
    private int age;

    @OneToMany(mappedBy = "register", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TodoList> todos;
    @OneToMany(mappedBy = "register", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserAi> userAiList=new ArrayList<>();



    public Register(String name, String email, String profession, String password, int age) {
        this.name = name;
        this.email = email;
        this.profession = profession;
        this.password = password;
        this.age = age;
    }
}

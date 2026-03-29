package com.example.worktunnelweb.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterDTO {
    private String id;
    private String name;
    private String email;
    private String profession;
    private String password;
    private int age;

    public String getUsername() {
        return name;
    }
}

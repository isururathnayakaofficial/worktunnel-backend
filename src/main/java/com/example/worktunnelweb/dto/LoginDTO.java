package com.example.worktunnelweb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    private String username;
    private String password;
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}

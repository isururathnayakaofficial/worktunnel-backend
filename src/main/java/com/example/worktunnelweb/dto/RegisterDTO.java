package com.example.worktunnelweb.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterDTO {
    private String name;
    private String email;
    private String profession;
    private int age;
}

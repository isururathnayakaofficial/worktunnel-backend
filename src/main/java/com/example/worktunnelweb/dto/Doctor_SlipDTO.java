package com.example.worktunnelweb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor_SlipDTO {
    private int id;
    private String patientName;
    private int age;
    private String description;
    private String medicine_list;
    private String email;
    private LocalDate date;

}

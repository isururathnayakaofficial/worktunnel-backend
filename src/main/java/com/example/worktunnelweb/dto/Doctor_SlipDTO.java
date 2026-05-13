package com.example.worktunnelweb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor_SlipDTO {
    private String fromEmail;
    private String appPassword;

    private String patientEmail;
    private String doctorName;
    private String patientName;
    private int age;
    private String description;
    private String medicine_list;
    private LocalDate date;

}

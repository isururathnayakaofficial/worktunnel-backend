package com.example.worktunnelweb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "doctor_slip")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor_Slip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // doctor sender email
    @Column(nullable = false)
    private String fromEmail;

    // gmail app password
    @Column(nullable = false)
    private String appPassword;

    private String doctorName;

    private String patientName;

    private int age;

    private String patientEmail;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String medicine_list;

    private LocalDate date;
}
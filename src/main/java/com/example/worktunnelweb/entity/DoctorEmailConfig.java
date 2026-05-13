//package com.example.worktunnelweb.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Table(name = "doctor_email_config")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class DoctorEmailConfig {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @Column(unique = true, nullable = false)
//    private String email;
//
//    @Column(nullable = false)
//    private String appPassword;
//}
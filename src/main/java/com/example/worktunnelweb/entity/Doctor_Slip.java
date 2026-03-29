package com.example.worktunnelweb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Doctor_Slip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String patientName;
    private int age;
    private String description;
    private String medicine_list;
    private String email;
    private LocalDate date;
    @PrePersist
    public void prePersist() {
        if (date == null) {
            date = LocalDate.now();
        }
    }
}

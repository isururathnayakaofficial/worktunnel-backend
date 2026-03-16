package com.example.worktunnelweb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String priority;
    private LocalDate date;
    private Time startTime;
    private Time Endtime;
    @ManyToOne()
    @JoinColumn(name = "register_id",nullable = false)
    private Register register;
}

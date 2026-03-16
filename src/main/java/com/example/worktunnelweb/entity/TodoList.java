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
    @Column(name = "starttime")
    private Time startTime;
    @Column(name = "endtime")
    private Time Endtime;
    private String status;
    @ManyToOne()
    @JoinColumn(name = "register_id",nullable = false)
    private Register register;
}

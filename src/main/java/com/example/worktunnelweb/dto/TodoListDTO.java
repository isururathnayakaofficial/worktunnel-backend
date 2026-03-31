package com.example.worktunnelweb.dto;

import lombok.*;

import java.sql.Time;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class TodoListDTO {
    private int id;
    private String title;
    private String priority;
    private LocalDate date;
    private Time startTime;
    private Time endTime;
    private String status;

}
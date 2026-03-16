package com.example.worktunnelweb.dto;

import lombok.*;
import lombok.experimental.StandardException;

import java.sql.Time;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TodoListDTO {
    private String title;
    private String priority;
    private LocalDate date;
    private Time starttime;
    private Time Endtime;
}

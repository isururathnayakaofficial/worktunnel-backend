package com.example.worktunnelweb.repository;

import com.example.worktunnelweb.entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Repository
public interface TodoListRepo extends JpaRepository<TodoList, Long> {
    boolean existsByRegisterIdAndDateAndStartTime(Long registerId, LocalDate date, Time startTime);
    Optional<TodoList> findByRegisterIdAndDateAndStartTime(
            Long registerId,
            LocalDate date,
            LocalTime startTime
    );


}

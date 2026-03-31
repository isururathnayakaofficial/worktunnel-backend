package com.example.worktunnelweb.repository;

import com.example.worktunnelweb.entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public interface TodoListRepo extends JpaRepository<TodoList, Long> {

    boolean existsByRegisterIdAndDateAndStartTime(Long registerId, LocalDate date, Time startTime);

    List<TodoList> findByRegisterId(Long registerId);

    // 🔥 Save conflict check
    @Query("SELECT t FROM TodoList t WHERE t.register.id = :registerId " +
            "AND t.date = :date " +
            "AND t.startTime < :endTime " +
            "AND t.Endtime > :startTime")
    List<TodoList> findConflictingTasks(
            @Param("registerId") Long registerId,
            @Param("date") LocalDate date,
            @Param("startTime") Time startTime,
            @Param("endTime") Time endTime
    );

    // 🔥 Update conflict check (exclude current task)
    @Query("SELECT t FROM TodoList t WHERE t.register.id = :registerId " +
            "AND t.date = :date " +
            "AND t.startTime < :endTime " +
            "AND t.Endtime > :startTime " +
            "AND t.id <> :todoId")
    List<TodoList> findConflictsForUpdate(
            @Param("registerId") Long registerId,
            @Param("date") LocalDate date,
            @Param("startTime") Time startTime,
            @Param("endTime") Time endTime,
            @Param("todoId") Long todoId
    );
}
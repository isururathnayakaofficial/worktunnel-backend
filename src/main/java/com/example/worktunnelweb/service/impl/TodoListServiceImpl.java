package com.example.worktunnelweb.service.impl;

import com.example.worktunnelweb.dto.TodoListDTO;
import com.example.worktunnelweb.entity.Register;
import com.example.worktunnelweb.entity.TodoList;
import com.example.worktunnelweb.repository.RegisterRepo;
import com.example.worktunnelweb.repository.TodoListRepo;
import com.example.worktunnelweb.service.TodoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoListServiceImpl implements TodoListService {
    private final RegisterRepo registerRepo;
    private final TodoListRepo todoListRepo;
    @Override
    public void saveTodoList(TodoListDTO todoListDTO, Long registeredId) {

        // Validate time
        if (todoListDTO.getStartTime().after(todoListDTO.getEndTime())) {
            throw new RuntimeException("Start time must be before end time");
        }

        // Check overlapping tasks
        List<TodoList> conflicts = todoListRepo.findConflictingTasks(
                registeredId,
                todoListDTO.getDate(),
                todoListDTO.getStartTime(),
                todoListDTO.getEndTime()
        );

        if (!conflicts.isEmpty()) {
            throw new RuntimeException("Time conflict! You already have a task within this time range.");
        }

        Register register = registerRepo.findById(String.valueOf(registeredId))
                .orElseThrow(() -> new RuntimeException("User not found"));

        TodoList todo = new TodoList();
        todo.setTitle(todoListDTO.getTitle());
        todo.setPriority(todoListDTO.getPriority());
        todo.setDate(todoListDTO.getDate());
        todo.setStartTime(todoListDTO.getStartTime());
        todo.setEndtime(todoListDTO.getEndTime());

        if (todoListDTO.getStatus() == null || todoListDTO.getStatus().isEmpty()) {
            todo.setStatus("PENDING");
        } else {
            todo.setStatus(todoListDTO.getStatus());
        }

        todo.setRegister(register);

        todoListRepo.save(todo);
    }

    @Override
    public void updateTodoList(TodoListDTO todoListDTO, Long todoID) {

        TodoList todo = todoListRepo.findById(todoID)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        // Validate time
        if (todoListDTO.getStartTime().after(todoListDTO.getEndTime())) {
            throw new RuntimeException("Start time must be before end time");
        }

        // Check conflicts (excluding current task)
        List<TodoList> conflicts = todoListRepo.findConflictsForUpdate(
                (long) todo.getRegister().getId(),
                todoListDTO.getDate(),
                todoListDTO.getStartTime(),
                todoListDTO.getEndTime(),
                todoID
        );

        if (!conflicts.isEmpty()) {
            throw new RuntimeException("Time conflict! Another task already exists in this time range.");
        }

        // Update
        todo.setTitle(todoListDTO.getTitle());
        todo.setPriority(todoListDTO.getPriority());
        todo.setStatus(todoListDTO.getStatus());
        todo.setDate(todoListDTO.getDate());
        todo.setStartTime(todoListDTO.getStartTime());
        todo.setEndtime(todoListDTO.getEndTime());

        todoListRepo.save(todo);
    }

    @Override
    public void deleteTodoList(Long todoId) {
        // Check user exists
        todoListRepo.findById(Long.valueOf(String.valueOf(todoId)))
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Delete all todos for the user
        todoListRepo.deleteById(todoId);

    }

    @Override
    public List<TodoListDTO> getTodoList(int registerId) {

        // check user exists
        registerRepo.findById(String.valueOf(registerId))
                .orElseThrow(() -> new RuntimeException("User not found"));

        // get todos for that user
        List<TodoList> todoListList = todoListRepo.findByRegisterId((long) registerId);

        return todoListList.stream().map(todo -> {
            TodoListDTO dto = new TodoListDTO();
            dto.setId(todo.getId());
            dto.setTitle(todo.getTitle());
            dto.setPriority(todo.getPriority());
            dto.setStatus(todo.getStatus());
            dto.setDate(todo.getDate());
            dto.setStartTime(todo.getStartTime());
            dto.setEndTime(todo.getEndtime());
            return dto;
        }).toList();
    }
}

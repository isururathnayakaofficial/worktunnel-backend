package com.example.worktunnelweb.service.impl;

import com.example.worktunnelweb.dto.TodoListDTO;
import com.example.worktunnelweb.entity.Register;
import com.example.worktunnelweb.entity.TodoList;
import com.example.worktunnelweb.repository.RegisterRepo;
import com.example.worktunnelweb.repository.TodoListRepo;
import com.example.worktunnelweb.service.TodoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
@RequiredArgsConstructor
public class TodoListServiceImpl implements TodoListService {
    private final RegisterRepo registerRepo;
    private final TodoListRepo todoListRepo;
    @Override
    public void saveTodoList(TodoListDTO todoListDTO,Long registeredId) {
        boolean exists = todoListRepo.existsByRegisterIdAndDateAndStartTime(
                registeredId,
                todoListDTO.getDate(),
                todoListDTO.getStartTime()
        );

        if (exists) {
            throw new RuntimeException("You already have a task at this time");
        }

        Register register = registerRepo.findById(String.valueOf(registeredId))
                .orElseThrow(() -> new RuntimeException("User not found"));

        TodoList todo = new TodoList();
        todo.setTitle(todoListDTO.getTitle());
        todo.setPriority(todoListDTO.getPriority());
        todo.setDate(todoListDTO.getDate());
        todo.setStartTime(todoListDTO.getStartTime());
        todo.setEndtime(todoListDTO.getEndTime());
        //justify the is the task completed or pending update
        if (todoListDTO.getStatus() == null || todoListDTO.getStatus().isEmpty()) {
            todo.setStatus("PENDING");
        } else {
            todo.setStatus(todoListDTO.getStatus());
        }

        // set relationship
        todo.setRegister(register);

        todoListRepo.save(todo);


    }

    @Override
    public void updateTodoList(TodoListDTO todoListDTO, Long todoID) {

        // Find existing
        TodoList todo = todoListRepo.findById(todoID)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        // Update fields
        todo.setTitle(todoListDTO.getTitle());
        todo.setPriority(todoListDTO.getPriority());
        todo.setStatus(todoListDTO.getStatus());
        todo.setDate(todoListDTO.getDate());
        todo.setStartTime(todoListDTO.getStartTime());
        todo.setEndtime(todoListDTO.getEndTime());

        // Save (this will UPDATE, not INSERT)
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
    public void getTodoList(String email) {

    }
}

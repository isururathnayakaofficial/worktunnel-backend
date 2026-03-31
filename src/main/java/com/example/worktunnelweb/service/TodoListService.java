package com.example.worktunnelweb.service;

import com.example.worktunnelweb.dto.TodoListDTO;

import java.util.List;

public interface TodoListService {
    void saveTodoList(TodoListDTO todoListDTO,Long registeredId);
    void updateTodoList(TodoListDTO todoListDTO,Long todoID);
    void deleteTodoList(Long todoID);
    List<TodoListDTO> getTodoList(int registerId);
}

package com.example.worktunnelweb.service;

import com.example.worktunnelweb.dto.TodoListDTO;

public interface TodoListService {
    void saveTodoList(TodoListDTO todoListDTO,Long registeredId);
    void updateTodoList(TodoListDTO todoListDTO,Long registeredId);
    void deleteTodoList(String email);
    void getTodoList(String email);
}

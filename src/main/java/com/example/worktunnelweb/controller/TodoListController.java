package com.example.worktunnelweb.controller;

import com.example.worktunnelweb.dto.TodoListDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/todo")
public class TodoListController {
    @PostMapping("/save")
    public void saveTodoList(@RequestBody TodoListDTO todoListDTO) {

    }
    @PutMapping("/update")
    public void updateTodoList(@RequestBody TodoListDTO todoListDTO) {

    }
    @DeleteMapping("/delete")
    public void deleteTodoList(@RequestParam String email) {    }

    @GetMapping("/get")
    public void getTodoList(@RequestParam String email) {    }
}

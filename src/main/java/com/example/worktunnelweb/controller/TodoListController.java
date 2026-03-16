package com.example.worktunnelweb.controller;

import com.example.worktunnelweb.dto.TodoListDTO;
import com.example.worktunnelweb.service.TodoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/todo")
public class TodoListController {

    private final TodoListService todoListService;


    @PostMapping("/save/{registerId}")
    public ResponseEntity<String> saveTodoList(
            @RequestBody TodoListDTO todoListDTO,
            @PathVariable Long registerId
    ) {

        todoListService.saveTodoList(todoListDTO, registerId);

        return ResponseEntity.ok("Todo saved successfully");
    }
    @PutMapping("/update")
    public void updateTodoList(@RequestBody TodoListDTO todoListDTO) {

    }
    @DeleteMapping("/delete")
    public void deleteTodoList(@RequestParam String email) {    }

    @GetMapping("/get")
    public void getTodoList(@RequestParam String email) {    }
}

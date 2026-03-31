package com.example.worktunnelweb.controller;

import com.example.worktunnelweb.dto.TodoListDTO;
import com.example.worktunnelweb.service.TodoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PutMapping("/update/{todoId}")
    public ResponseEntity <String> updateTodoList(@RequestBody TodoListDTO todoListDTO ,@PathVariable Long todoId) {
        todoListService.updateTodoList(todoListDTO, todoId);
        return ResponseEntity.ok("Todo Updated");

    }
    @DeleteMapping("/delete/{todoID}")
    public ResponseEntity <String> deleteTodoList(@PathVariable Long todoID) {
        todoListService.deleteTodoList(todoID);
        return ResponseEntity.ok("Todo Deleted");
    }

    @GetMapping("/get/{registerId}")
    public <TodoDTO> ResponseEntity<?> getTodoList(@PathVariable int registerId) {
        List<TodoDTO> todos = (List<TodoDTO>) todoListService.getTodoList(registerId); // fetch list

        // Return the actual list as JSON
        return ResponseEntity.ok(todos);
    }
}

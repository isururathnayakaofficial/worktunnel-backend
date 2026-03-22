package com.example.worktunnelweb.controller;

import com.example.worktunnelweb.service.UserTask;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/admin/User")
public class UserController {
    private UserTask userTask;
    @DeleteMapping("/delete")
    public void deleteUser(){

    }
    @GetMapping("/get")
    public void SearchUser(){

    }
}

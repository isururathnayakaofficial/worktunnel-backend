package com.example.worktunnelweb.controller;

import com.example.worktunnelweb.dto.LoginDTO;
import com.example.worktunnelweb.dto.RegisterDTO;
import com.example.worktunnelweb.service.AuthService;
import com.example.worktunnelweb.service.RegisterService;
import com.example.worktunnelweb.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO request) {

        authenticationManager.authenticate((Authentication) request);
        return null;
    }
    @PostMapping("/register")
    public void registerUser(@RequestBody RegisterDTO request ) {
       authService.register(request);
    }
    @PostMapping("/chat-log")
    public void saveKeyword(@RequestBody Map<String,String> data){

        String keyword = data.get("keyword");

        System.out.println("User searched: " + keyword);

        // Save to DB
    }
}
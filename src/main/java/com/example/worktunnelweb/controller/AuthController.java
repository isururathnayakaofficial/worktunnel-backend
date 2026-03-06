package com.example.worktunnelweb.controller;

import com.example.worktunnelweb.dto.AuthDTO;
import com.example.worktunnelweb.dto.AuthResponseDTO;
import com.example.worktunnelweb.dto.RegisterDTO;
import com.example.worktunnelweb.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
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
    public ResponseEntity<?> login(@RequestBody AuthDTO authDTO) {

        AuthResponseDTO response = authService.authenticate(authDTO);

        return ResponseEntity.ok(response);
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
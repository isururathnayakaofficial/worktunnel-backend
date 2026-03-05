package com.example.worktunnelweb.controller;

import com.example.worktunnelweb.dto.LoginDTO;
import com.example.worktunnelweb.dto.RegisterDTO;
import com.example.worktunnelweb.service.RegisterService;
import com.example.worktunnelweb.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RegisterService registerService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        String token = jwtUtil.generateToken(request.getUsername());

        return ResponseEntity.ok(token);
    }
    @PostMapping("/register")
    public void registerUser(@RequestBody RegisterDTO request ) {
          registerService.register(request);
    }
}
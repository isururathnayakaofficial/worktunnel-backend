package com.example.worktunnelweb.service;

import com.example.worktunnelweb.dto.AuthDTO;
import com.example.worktunnelweb.dto.AuthResponseDTO;
import com.example.worktunnelweb.dto.RegisterDTO;
import com.example.worktunnelweb.entity.Register;
import com.example.worktunnelweb.repository.RegisterRepo;
import com.example.worktunnelweb.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {


    private final RegisterRepo registerRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthResponseDTO authenticate(AuthDTO authDTO) {

        // find register user from database
        Register user = (Register) registerRepo.findByName(authDTO.getUsername())
                .orElseThrow(() ->
                        new UsernameNotFoundException(authDTO.getUsername()));

        // check password
        if (!passwordEncoder.matches(authDTO.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }

        // generate JWT token
        String token = jwtUtil.generateToken(authDTO.getUsername());
        return new AuthResponseDTO(token);

    }

    public String register(RegisterDTO registerDTO) {

        // check email
        if (registerRepo.existsByEmail(registerDTO.getEmail())) {
            throw new RuntimeException("Email is already in use");
        }
        // create user
        Register user = Register.builder()
                .name(registerDTO.getName())
                .profession(registerDTO.getProfession())
                .email(registerDTO.getEmail())
                .password(passwordEncoder.encode(registerDTO.getPassword()))
                .age(registerDTO.getAge())
                .build();

        registerRepo.save(user);

        return "User registered successfully";
    }
}
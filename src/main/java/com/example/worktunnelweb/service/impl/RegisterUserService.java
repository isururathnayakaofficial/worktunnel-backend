package com.example.worktunnelweb.service.impl;

import com.example.worktunnelweb.dto.RegisterDTO;
import com.example.worktunnelweb.entity.Register;
import com.example.worktunnelweb.repository.RegisterRepo;
import com.example.worktunnelweb.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUserService implements RegisterService {

    private final RegisterRepo registerRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(RegisterDTO registerDTO) {

        String encryptedPassword = passwordEncoder.encode(registerDTO.getPassword());

        registerRepo.save(
                new Register(
                        registerDTO.getName(),
                        registerDTO.getEmail(),
                        registerDTO.getProfession(),
                        encryptedPassword,
                        registerDTO.getAge()
                )
        );
    }
}
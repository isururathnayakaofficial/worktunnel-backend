package com.example.worktunnelweb.service.impl;

import com.example.worktunnelweb.dto.RegisterDTO;
import com.example.worktunnelweb.entity.Register;
import com.example.worktunnelweb.repository.RegisterRepo;
import com.example.worktunnelweb.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUserService implements RegisterService {

    private final RegisterRepo registerRepo;
    @Override
    public void register(RegisterDTO registerDTO) {
          registerRepo.save(
                  new Register(registerDTO.getName(),
                            registerDTO.getEmail(),
                          registerDTO.getProfession(),
                          registerDTO.getAge())
                          );
    }
}

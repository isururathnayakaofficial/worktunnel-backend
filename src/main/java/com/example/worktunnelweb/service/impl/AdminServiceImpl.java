package com.example.worktunnelweb.service.impl;

import com.example.worktunnelweb.dto.AdminDTO;

import com.example.worktunnelweb.entity.Admin;
import com.example.worktunnelweb.repository.AdminRepo;
import com.example.worktunnelweb.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {


    private final PasswordEncoder passwordEncoder;
    private final AdminRepo adminRepo;

    @Override
    public void saveAdmin(AdminDTO adminDTO) {

        if (adminRepo.existsByEmail(adminDTO.getEmail())) {
            throw new RuntimeException("Email is already in use");
        }
        if (adminRepo.existsByPassword(adminDTO.getPassword())) {
            throw new RuntimeException("Password is already in use");
        }
      Admin admin = new Admin();
      admin.setAdminName(adminDTO.getAdminName());
      admin.setEmail(adminDTO.getEmail());
      admin.setContact(adminDTO.getContact());
      admin.setPassword(passwordEncoder.encode(adminDTO.getPassword()));
      admin.setRoleName(adminDTO.getRoleName());
      adminRepo.save(admin);

    }

    @Override
    public void updateAdmin(AdminDTO adminDTO,int id) {

     Admin admin = adminRepo.findById(String.valueOf(id)).orElseThrow(() -> new RuntimeException("Admin not found"));
     admin.setAdminName(adminDTO.getAdminName());
     admin.setEmail(adminDTO.getEmail());
     admin.setContact(adminDTO.getContact());
     admin.setPassword(passwordEncoder.encode(adminDTO.getPassword()));
     admin.setRoleName(adminDTO.getRoleName());
     adminRepo.save(admin);

    }

    @Override
    public void deleteAdmin(int id) {
        if (!adminRepo.existsById(String.valueOf(id))) {
            throw new RuntimeException("Admin not found");
        }
        adminRepo.deleteById(String.valueOf(id));

    }
}

package com.example.worktunnelweb.service.impl;

import com.example.worktunnelweb.dto.AdminDTO;
import com.example.worktunnelweb.dto.SuperAdminDTO;
import com.example.worktunnelweb.entity.Admin;
import com.example.worktunnelweb.repository.AdminRepo;
import com.example.worktunnelweb.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {


    private final AdminRepo adminRepo;
    @Override
    public void saveAdmin(SuperAdminDTO adminDTO) {

        if (adminRepo.existsByEmail(adminDTO.getEmail())) {
            throw new RuntimeException("Email is already in use");
        }
      Admin admin = new Admin();
      admin.setAdminName(adminDTO.getAdminName());
      admin.setEmail(adminDTO.getEmail());
      admin.setContact(adminDTO.getContact());
      admin.setPassword(adminDTO.getPassword());
      admin.getRoleName();
      adminRepo.save(admin);

    }

    @Override
    public void updateAdmin(AdminDTO adminDTO) {

    }

    @Override
    public void deleteAdmin(AdminDTO adminDTO) {

    }
}

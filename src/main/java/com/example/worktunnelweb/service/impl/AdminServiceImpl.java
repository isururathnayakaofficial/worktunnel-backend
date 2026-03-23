package com.example.worktunnelweb.service.impl;

import com.example.worktunnelweb.dto.AdminDTO;
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
    public void saveAdmin(AdminDTO adminDTO) {
      Admin admin = new Admin();
      admin.getId(),
      admin.getAdminName(),
        admin.getEmail(),
        admin.getContact(),
        admin.getRoleName();
    }

    @Override
    public void updateAdmin(AdminDTO adminDTO) {

    }

    @Override
    public void deleteAdmin(AdminDTO adminDTO) {

    }
}

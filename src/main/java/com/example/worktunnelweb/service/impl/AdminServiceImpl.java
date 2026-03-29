package com.example.worktunnelweb.service.impl;

import com.example.worktunnelweb.dto.AdminAuthDTO;
import com.example.worktunnelweb.dto.AdminDTO;

import com.example.worktunnelweb.dto.AdminResponse;
import com.example.worktunnelweb.entity.Admin;
import com.example.worktunnelweb.repository.AdminRepo;
import com.example.worktunnelweb.service.AdminService;
import com.example.worktunnelweb.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {


    private final PasswordEncoder passwordEncoder;
    private final AdminRepo adminRepo;
    private final JwtUtil jwtUtil;
    @Autowired
    private final EmailService emailService;

    @Override
    public void saveAdmin(AdminDTO adminDTO) {

        if (adminRepo.existsByEmail(adminDTO.getEmail())) {
            throw new RuntimeException("Email is already in use");
        }
        if (adminRepo.existsByPassword(adminDTO.getPassword())) {
            throw new RuntimeException("Password is already in use");
        }
      Admin admin = new Admin();
        admin.setId(adminDTO.getId());
      admin.setAdminName(adminDTO.getAdminName());
      admin.setEmail(adminDTO.getEmail());
      admin.setContact(adminDTO.getContact());
      admin.setPassword(passwordEncoder.encode(adminDTO.getPassword()));
      admin.setRoleName(adminDTO.getRoleName());
      Admin saveAdmin =adminRepo.save(admin);
      if (saveAdmin != null && saveAdmin.getEmail()!=null) {
          emailService.sendAdminCredentials(saveAdmin.getEmail(),saveAdmin.getAdminName(), adminDTO.getPassword());
      }else {
          throw new RuntimeException("Failed to save admin or email is null");
      }
    }

    @Override
    public void updateAdmin(AdminDTO adminDTO,int id) {

     Admin admin = adminRepo.findById(String.valueOf(id)).orElseThrow(() -> new RuntimeException("Admin not found"));
     admin.setAdminName(adminDTO.getAdminName());
     admin.setEmail(adminDTO.getEmail());
     admin.setContact(adminDTO.getContact());
     admin.setPassword(passwordEncoder.encode(adminDTO.getPassword()));
     admin.setRoleName(adminDTO.getRoleName());

     Admin updateAdmin =adminRepo.save(admin);
     if (updateAdmin != null && updateAdmin.getEmail()!=null) {
         emailService.sendUpdatedAdminCredentials(updateAdmin.getEmail(),updateAdmin.getAdminName(), adminDTO.getPassword());
     }


    }

    @Override
    public void deleteAdmin(int id) {
        if (!adminRepo.existsById(String.valueOf(id))) {
            throw new RuntimeException("Admin not found");
        }
        adminRepo.deleteById(String.valueOf(id));

    }

    @Override
    public AdminResponse loginAdmin(AdminAuthDTO adminAuthDTO) {
        Admin admin = (Admin) adminRepo.findByAdminName(adminAuthDTO.getUsername())
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        if (!passwordEncoder.matches(adminAuthDTO.getPassword(), admin.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        String token=jwtUtil.generateToken(admin.getAdminName());
        return new AdminResponse(token);

    }

    @Override
    public List<AdminDTO> getAllAdmins() {
        List<Admin> adminList = (List<Admin>) adminRepo.findAll();

        return adminList.stream().map(admin -> {
            AdminDTO dto = new AdminDTO();
            dto.setId(admin.getId());
            dto.setAdminName(admin.getAdminName());
            dto.setEmail(admin.getEmail());
            dto.setContact(admin.getContact());
            dto.setPassword(admin.getPassword());
            dto.setRoleName(admin.getRoleName());
            return dto;
        }).toList();
    }
}

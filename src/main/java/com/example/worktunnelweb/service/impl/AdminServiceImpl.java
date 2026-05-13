package com.example.worktunnelweb.service.impl;

import com.example.worktunnelweb.dto.AdminAuthDTO;
import com.example.worktunnelweb.dto.AdminDTO;
import com.example.worktunnelweb.dto.AdminResponse;
import com.example.worktunnelweb.entity.Admin;
import com.example.worktunnelweb.repository.AdminRepo;
import com.example.worktunnelweb.service.AdminService;
import com.example.worktunnelweb.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final PasswordEncoder passwordEncoder;
    private final AdminRepo adminRepo;
    private final JwtUtil jwtUtil;
    private final EmailService emailService;


    @Override
    public void saveAdmin(AdminDTO adminDTO) {

        if (adminRepo.existsByEmail(adminDTO.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email is already in use");
        }

        Admin admin = new Admin();
        admin.setAdminName(adminDTO.getAdminName());
        admin.setEmail(adminDTO.getEmail());
        admin.setContact(adminDTO.getContact());
        admin.setRoleName(adminDTO.getRoleName());


        admin.setPassword(passwordEncoder.encode(adminDTO.getPassword()));

        Admin savedAdmin = adminRepo.save(admin);

        if (savedAdmin.getEmail() != null) {
            emailService.sendAdminCredentials(
                    savedAdmin.getEmail(),
                    savedAdmin.getAdminName(),
                    adminDTO.getPassword() // send plain password via email
            );
        }
    }


    @Override
    public void updateAdmin(AdminDTO adminDTO, int id) {

        Admin admin = adminRepo.findById(String.valueOf(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found"));

        admin.setAdminName(adminDTO.getAdminName());
        admin.setEmail(adminDTO.getEmail());
        admin.setContact(adminDTO.getContact());
        admin.setRoleName(adminDTO.getRoleName());


        admin.setPassword(passwordEncoder.encode(adminDTO.getPassword()));

        Admin updatedAdmin = adminRepo.save(admin);

        if (updatedAdmin.getEmail() != null) {
            emailService.sendUpdatedAdminCredentials(
                    updatedAdmin.getEmail(),
                    updatedAdmin.getAdminName(),
                    adminDTO.getPassword()
            );
        }
    }


    @Override
    public void deleteAdmin(int id) {

        if (!adminRepo.existsById(String.valueOf(id))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found");
        }

        adminRepo.deleteById(String.valueOf(id));
    }


    @Override
    public AdminResponse loginAdmin(AdminAuthDTO adminAuthDTO) {

        Admin admin = adminRepo.findByAdminName(adminAuthDTO.getUsername())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found"));


        if (!passwordEncoder.matches(adminAuthDTO.getPassword(), admin.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid password");
        }


        String token = jwtUtil.generateToken(admin.getAdminName());

        return new AdminResponse(token);
    }


    @Override
    public List<AdminDTO> getAllAdmins() {

        List<Admin> adminList = (List<Admin>) adminRepo.findAll();

        return adminList.stream().map(admin -> {
            AdminDTO dto = new AdminDTO();
            dto.setId(admin.getId());
            dto.setAdminName(admin.getAdminName());
            dto.setContact(admin.getContact());
            dto.setRoleName(admin.getRoleName());
            dto.setEmail(admin.getEmail());



            return dto;
        }).toList();
    }
}
package com.example.worktunnelweb.controller;

import com.example.worktunnelweb.dto.SuperAdminDTO;
import com.example.worktunnelweb.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {
    private final AdminService adminService;
    @PostMapping("/save")
    public void saveAdmin(@RequestBody SuperAdminDTO adminDTO) {
        adminService.saveAdmin(adminDTO);

    }
    @PostMapping("/login")
    public void login (@RequestBody SuperAdminDTO adminDTO) {
    }
    @PutMapping("/update")
    public void Update(@RequestBody SuperAdminDTO adminDTO) {

    }

}

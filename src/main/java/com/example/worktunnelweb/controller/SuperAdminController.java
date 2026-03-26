package com.example.worktunnelweb.controller;

import com.example.worktunnelweb.dto.AdminDTO;
import com.example.worktunnelweb.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/superadmin")
@RequiredArgsConstructor
public class SuperAdminController {
    private final AdminService adminService;
    @PostMapping("/save")
    public void addAdmin(@RequestBody AdminDTO adminDTO){
        adminService.saveAdmin(adminDTO);
    }
}

package com.example.worktunnelweb.controller;

import com.example.worktunnelweb.dto.AdminDTO;
import com.example.worktunnelweb.dto.SuperAdminDTO;
import com.example.worktunnelweb.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/superadmin")
@RequiredArgsConstructor
public class SuperAdminController {
    private final AdminService adminService;
    public void addAdmin(@RequestBody SuperAdminDTO adminDTO){
        adminService.saveAdmin(adminDTO);
    }
}

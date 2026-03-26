package com.example.worktunnelweb.controller;


import com.example.worktunnelweb.dto.AdminDTO;
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
    public void saveAdmin(@RequestBody AdminDTO adminDTO) {
        adminService.saveAdmin(adminDTO);

    }
    @PostMapping("/login")
    public void login (@RequestBody AdminDTO adminDTO) {
    }
    @PutMapping("/update/{id}")
    public void Update(@RequestBody AdminDTO adminDTO, @PathVariable int id) {
        adminService.updateAdmin(adminDTO,id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteAdmin(@PathVariable int id) {
        adminService.deleteAdmin(id);
    }

}

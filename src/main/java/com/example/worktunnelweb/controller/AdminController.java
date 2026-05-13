package com.example.worktunnelweb.controller;


import com.example.worktunnelweb.dto.AdminAuthDTO;
import com.example.worktunnelweb.dto.AdminDTO;
import com.example.worktunnelweb.dto.AdminResponse;
import com.example.worktunnelweb.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController //controller + responsebody
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {
    //dev manually access part
    private final AdminService adminService;
    @PostMapping("/save")
    public void saveAdmin(@RequestBody AdminDTO adminDTO) {
        adminService.saveAdmin(adminDTO);

    }
    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody AdminAuthDTO adminAuthDTO) {
        AdminResponse response=adminService.loginAdmin(adminAuthDTO);
        return ResponseEntity.ok(
                Map.of(
                        "status", "success",
                        "message", "Login successful",
                        "data", response
                )
        );
    }
    @PutMapping("/update/{id}")

    public ResponseEntity <?> Update(@RequestBody AdminDTO adminDTO, @PathVariable int id) {
        adminService.updateAdmin(adminDTO,id);
        return ResponseEntity.ok("Admin updated successfully");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable int id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.ok("Admin deleted successfully");
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllAdmins() {
        return ResponseEntity.ok(adminService.getAllAdmins());
    }
}

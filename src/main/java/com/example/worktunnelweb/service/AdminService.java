package com.example.worktunnelweb.service;

import com.example.worktunnelweb.dto.AdminDTO;
import com.example.worktunnelweb.dto.SuperAdminDTO;

public interface AdminService {
    void saveAdmin(SuperAdminDTO adminDTO);
    void updateAdmin(AdminDTO adminDTO);
    void deleteAdmin(AdminDTO adminDTO);

}

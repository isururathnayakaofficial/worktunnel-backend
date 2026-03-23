package com.example.worktunnelweb.service;

import com.example.worktunnelweb.dto.AdminDTO;

public interface AdminService {
    void saveAdmin(AdminDTO adminDTO);
    void updateAdmin(AdminDTO adminDTO);
    void deleteAdmin(AdminDTO adminDTO);

}

package com.example.worktunnelweb.service;


import com.example.worktunnelweb.dto.AdminAuthDTO;
import com.example.worktunnelweb.dto.AdminDTO;
import com.example.worktunnelweb.dto.AdminResponse;

public interface AdminService {
    void saveAdmin(AdminDTO adminDTO);
    void updateAdmin(AdminDTO adminDTO,int id);
    void deleteAdmin(int id);
    AdminResponse loginAdmin(AdminAuthDTO adminAuthDTO);

}

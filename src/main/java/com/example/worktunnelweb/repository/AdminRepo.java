package com.example.worktunnelweb.repository;

import com.example.worktunnelweb.entity.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends CrudRepository<Admin, String> {
    boolean existsByEmail(String attr0);
    boolean existsByPassword(String password);


}

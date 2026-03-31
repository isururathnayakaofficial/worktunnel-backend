package com.example.worktunnelweb.repository;

import com.example.worktunnelweb.entity.Register;
import org.springframework.data.repository.CrudRepository;

import java.lang.ScopedValue;
import java.util.Optional;

public interface RegisterRepo extends CrudRepository<Register, String> {

    Optional<Object> findByName(String name);

    boolean existsByEmail(String email);


}

package com.example.worktunnelweb.repository;



import com.example.worktunnelweb.entity.Doctor_Slip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Doctor_SlipRepo extends CrudRepository<Doctor_Slip, Integer> {

}

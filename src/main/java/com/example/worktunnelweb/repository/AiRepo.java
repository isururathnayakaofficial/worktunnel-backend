package com.example.worktunnelweb.repository;



import com.example.worktunnelweb.entity.UserAi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AiRepo extends CrudRepository<UserAi,String> {
}

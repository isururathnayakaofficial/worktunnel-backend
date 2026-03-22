package com.example.worktunnelweb.repository;


import com.example.worktunnelweb.entity.AnonymousAi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnonymousAiRepo extends CrudRepository<AnonymousAi,String> {


}

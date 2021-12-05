package com.example.danocoffee.repository;

import com.example.danocoffee.data.Manager;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, String> {
    public Optional<Manager> findByMnId(String mnId);

    public Manager findByMnName(String mnName);
    
    public Manager deleteByMnId(String mnId);
}
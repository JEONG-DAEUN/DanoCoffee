package com.example.danocoffee.repository;

import com.example.danocoffee.data.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    public Optional<Manager> findByMnId(String mnId);
}

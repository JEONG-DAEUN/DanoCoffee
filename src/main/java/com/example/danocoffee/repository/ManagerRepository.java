package com.example.danocoffee.repository;

import com.example.danocoffee.data.Manager;
import com.example.danocoffee.data.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    public Optional<Manager> findBymnId(String mnId);

    public Manager findByMnId(String mnId);
}

package com.example.danocoffee.repository;

import com.example.danocoffee.data.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, String> {

}

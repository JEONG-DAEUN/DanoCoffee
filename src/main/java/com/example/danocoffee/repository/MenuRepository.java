package com.example.danocoffee.repository;

import com.example.danocoffee.data.Manager;
import com.example.danocoffee.data.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
    public Menu findBymName(String mName);
}

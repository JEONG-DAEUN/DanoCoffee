package com.example.danocoffee.repository;

import com.example.danocoffee.data.Category;
import com.example.danocoffee.data.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}

package com.example.danocoffee.repository;

import com.example.danocoffee.data.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderListRepository extends JpaRepository<OrderList,Integer> {

}

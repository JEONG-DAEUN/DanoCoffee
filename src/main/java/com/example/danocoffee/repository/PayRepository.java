package com.example.danocoffee.repository;

import com.example.danocoffee.data.Pay;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PayRepository extends JpaRepository<Pay, Integer> {
	
	@Query(value = 
			"SELECT sum(p_payment) AS totalPayment ,YEAR(p_time) AS pday FROM pay GROUP BY pday"
			, nativeQuery = true)
	public List<List<String>> findByGroupYear();
}
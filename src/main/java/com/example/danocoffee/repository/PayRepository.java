package com.example.danocoffee.repository;

import com.example.danocoffee.data.Pay;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PayRepository extends JpaRepository<Pay, Integer> {
	
	@Query(value = 
			"SELECT sum(p_payment) AS totalPayment ,YEAR(p_time) AS pday FROM pay GROUP BY pday ORDER BY pday DESC"
			, nativeQuery = true)
	public List<List<String>> findByGroupYear();
	
	@Query(value = 
			"SELECT sum(p_payment) AS totalPayment ,MONTH(p_time) AS pday FROM pay WHERE YEAR(p_time) = YEAR(CURDATE()) GROUP BY pday ORDER BY pday ASC"
			, nativeQuery = true)
	public List<List<String>> findByGroupMonth();
	
	@Query(value = 
			"SELECT sum(p_payment) AS totalPayment ,DAY(p_time) AS pday FROM pay  WHERE MONTH(p_time) = MONTH(CURDATE()) GROUP BY pday ORDER BY pday ASC"
			, nativeQuery = true)
	public List<List<String>> findByGroupDay();
	
	@Query(value = 
			"SELECT sum(p_payment) AS totalPayment ,HOUR(p_time) AS pday FROM pay  WHERE DAY(p_time) = DAY(CURDATE()) GROUP BY pday ORDER BY pday ASC"
			, nativeQuery = true)
	public List<List<String>> findByGroupToday();
	
	
	
	
	
}
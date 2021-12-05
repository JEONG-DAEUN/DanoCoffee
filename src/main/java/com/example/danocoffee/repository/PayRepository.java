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
	
	@Query(value = 
			"SELECT c.c_name AS 카테고리,SUM(o.orl_count) AS 판매량 ,SUM(o.orl_payment) AS 총판매액\r\n"
			+ "FROM pay p, orderlist o, menu m, category c \r\n"
			+ "WHERE p.p_id = o.p_id AND m.m_id= o.m_id AND c.c_id = m.c_id AND MONTH(p_time) = MONTH(CURDATE())\r\n"
			+ "GROUP BY 카테고리\r\n"
			+ "ORDER BY 판매량"
			, nativeQuery = true)
	public Object[] findByGroupCategory();
	
	@Query(value = 
			"SELECT menu.m_name AS menus, SUM(orderlist.orl_count) AS amount ,SUM(orderlist.orl_payment) AS totalPayment "
			+ "FROM pay, orderlist, menu "
			+ "WHERE pay.p_id = orderlist.p_id AND menu.m_id= orderlist.m_id  AND DAY(p_time) = DAY(CURDATE()) GROUP BY menus ORDER BY menus"
			, nativeQuery = true)
	public Object[] findByGroupMenuDay();
	
	@Query(value = 
			"SELECT menu.m_name AS menus, SUM(orderlist.orl_count) AS amount ,SUM(orderlist.orl_payment) AS totalPayment "
			+ "FROM pay, orderlist, menu "
			+ "WHERE pay.p_id = orderlist.p_id AND menu.m_id= orderlist.m_id  AND MONTH(p_time) = MONTH(CURDATE()) GROUP BY menus ORDER BY menus"
			, nativeQuery = true)
	public Object[] findByGroupMenuMonth();
	
	@Query(value = 
			"SELECT menu.m_name AS menus, SUM(orderlist.orl_count) AS amount ,SUM(orderlist.orl_payment) AS totalPayment "
			+ "FROM pay, orderlist, menu "
			+ "WHERE pay.p_id = orderlist.p_id AND menu.m_id= orderlist.m_id  AND YEAR(p_time) = YEAR(CURDATE()) GROUP BY menus ORDER BY menus"
			, nativeQuery = true)
	public Object[] findByGroupMenuYear();
	
	
	
	
}
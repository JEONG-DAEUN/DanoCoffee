package com.example.danocoffee.repository;

import com.example.danocoffee.data.OrderList;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderListRepository extends JpaRepository<OrderList, Integer>{
	
	@Query(value = 
			"SELECT"
			+ "MONTH(p.p_time) as 월, m.m_name AS 메뉴명 , SUM(o.orl_count) AS 구매횟수, SUM(o.orl_payment) AS 판매액"
			+ "FROM pay p, orderlist o, menu m"
			+ "WHERE p.p_id = o.p_id and o.m_id = m.m_id"
			+ "GROUP BY 메뉴명"
			+ "ORDER BY 월", nativeQuery = true)  
			List<OrderList> findGroupByData();
	
	
	// gradle 프로젝트 배포 빌드 방법 : 1. war 파일로 배포 프로젝트 복사본 압축  2.JAR 파일로 배포 실행할 수 있는것 없는것으로 구분 
	// jar 파일로 만들기 프로젝트 폴더 에 들어와 cmd 치고 창에 dir 치고 gradle build친다. 그럼 생성
}
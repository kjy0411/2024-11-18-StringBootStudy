package com.sist.web.repository;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.*;
/*
 * 	Wrapper
 * 		=> 데이터를 쉽게 사용이 가능하게 만든 클래스
 * 		=> 제네릭스에서는 일반 데이터형을 사용할 수 없다 => Wrapper 클래스 이용
 * 		=> 데이터가 두개 이상일 경우에는 int => Integer 사용
 * 		=> JPA
 * 			장점 : SQL문장을 몰라도 사용, 소스가 간결
 * 				  ----------------- 메소드 규칙
 * 				  WHERE문장을 지원하지 않는다
 * 				  findBy컬럼 + Option
 * 			단점 : 가독성이 낮다
 * 			------------------------------------- MyBatis
 * 
 * 							| 데이터 변경
 * 		=> Controller => Service => Repository(DAO)
 * 				| 						|
 * 			데이터 전송 (결과값)			데이터베이스 연동
 * 								|
 * 							의존성이 낮게 (다른 영향이 없게 만든다) => 유지보수
 * 
 * 		=> 분석
 * 		   톰캣 : web.xml => 확장자
 * 				 application-context.xml ...
 * 		   Controller => Service => DAO => JSP
 * 
 * 		1. 교육 : 소스를 주고 분석
 * 		   ------------------
 * 			메뉴얼 => 문서작업 : 프로젝트 소스의 흐름
 * 		2. CSS/HTML/FRONT/DataBase/Back
 * 		   ----------------------------
 */
public interface BusanFoodRepository extends JpaRepository<BusanFoodEntity, Integer>{
	@Query(value = "SELECT fno,poster,name,num "
			+ "FROM (SELECT fno,poster,name,rownum as num "
			+ "FROM (SELECT fno,poster,name "
			+ "FROM busan_food ORDER BY fno)) "
			+ "WHERE num BETWEEN :start AND :end",nativeQuery = true)
	public List<BusanFoodVO> busanFoodListData(@Param("start") Integer start,@Param("end") Integer end);
	
	public BusanFoodEntity findByFno(int fno);
}

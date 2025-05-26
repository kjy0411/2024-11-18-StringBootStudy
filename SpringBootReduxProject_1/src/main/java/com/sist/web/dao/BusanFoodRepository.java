package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.vo.*;
@Repository
public interface BusanFoodRepository extends JpaRepository<BusanFoodEntity, Integer>{
	@Query(value = "SELECT fno,name,poster FROM busan_food "
			+ "ORDER BY fno ASC "
			+ "LIMIT :start,12",nativeQuery = true)
	public List<BusanFoodVO> busanFoodList(@Param("start") Integer start);
	// SELECT * FROM busan_food WHERE fno=?
	public BusanFoodEntity findByFno(int fno);
}

package com.sist.web.repository;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
/*
 * 	interface ===== interface
 * 			  extends
 * 
 *  interface ===== class
 *  		  implements
 */
import com.sist.web.entity.*;
@Repository
public interface BusanInfoRepository extends JpaRepository<BusanInfoEntity, Integer>{
	@Query(value = "SELECT no,poster,title,num "
			+ "FROM (SELECT no,poster,title,rownum as num "
			+ "FROM (SELECT no,poster,title "
			+ "FROM busan_info ORDER BY no)) "
			+ "WHERE num BETWEEN :start AND :end",nativeQuery = true)
	public List<BusanInfoVO> busanInfoListData(@Param("start") Integer start,@Param("end") Integer end);
	
	public BusanInfoEntity findByNo(int no);
}

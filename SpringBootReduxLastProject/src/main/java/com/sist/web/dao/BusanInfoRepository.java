package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.entity.*;
@Repository
public interface BusanInfoRepository extends JpaRepository<BusanInfoEntity, Integer>{
	@Query(value = "SELECT * FROM busan_info "
			+ "ORDER BY no ASC "
			+ "LIMIT 0,5",nativeQuery = true)
	public List<BusanInfoEntity> busanInfoData();
	
	@Query(value = "SELECT * FROM busan_info "
			+ "WHERE cno=:cno "
			+ "ORDER BY no ASC "
			+ "LIMIT :start,12",nativeQuery = true)
	public List<BusanInfoEntity> busanInfoListData(@Param("cno") Integer cno, @Param("start") Integer start);
	
	@Query(value = "SELECT CEIL(COUNT(*)/12.0) FROM busan_info "
			+ "WHERE cno=:cno",nativeQuery = true)
	public int busanInfoTotalPage(@Param("cno") Integer cno);
	/*
	SQL
	@Query(value = "SELECT * FROM busan_info "
			+ "WHERE title LIKE CONCAT('%',:title,'%')",nativeQuery = true)
	public List<BusanInfoEntity> busanFindData(@Param("title") String title);
	*/
	// JPA
	public List<BusanInfoEntity> findByTitleContaining(@Param("title") String title);
}

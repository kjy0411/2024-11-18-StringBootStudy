package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.entity.*;

@Repository
public interface NovelRepository extends JpaRepository<NovelEntity, Integer>{
	@Query(value = "SELECT * FROM novel "
			+ "ORDER BY avgstar DESC, RAND() "
			+ "LIMIT 0,12",nativeQuery = true)
	public List<NovelEntity> mainNovelData();
	
	@Query(value = "SELECT * FROM novel "
			+ "ORDER BY no ASC "
			+ "LIMIT :start,12",nativeQuery = true)
	public List<NovelEntity> novelListData(@Param("start") int start);
	
	@Query(value = "SELECT CEIL(COUNT(*)/12.0) FROM novel")
	public int novelTotalPage();
	
	public NovelEntity findByNo(int no);
	
	@Query(value = "SELECT * FROM novel "
			+ "WHERE title LIKE CONCAT('%',:fd,'%') AND CONCAT(' ',genre,' ') LIKE CONCAT('% ',:genre,'%') "
			+ "ORDER BY no ASC "
			+ "LIMIT :start,12",nativeQuery = true)
	public List<NovelEntity> novelFindByFdGenre(@Param("fd") String fd, @Param("genre") String genre, @Param("start") Integer start);
	
	@Query(value = "SELECT CEIL(COUNT(*)/12.0) FROM novel "
			+ "WHERE title LIKE CONCAT('%',:fd,'%') "
			+ "AND CONCAT(' ',genre,' ') LIKE CONCAT('% ',:genre,'%')",nativeQuery = true)
	public int novelFindTotalPage(@Param("fd") String fd, @Param("genre") String genre);
}

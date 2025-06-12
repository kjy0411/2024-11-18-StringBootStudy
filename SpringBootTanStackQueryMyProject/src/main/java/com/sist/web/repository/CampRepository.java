package com.sist.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.entity.*;
import com.sist.web.vo.*;
/*
public int getCno();
	public String getTitle();
	public String getPoster();
	public String getIntro();
	public String getDonm();
	public String getManagesttus();
	public int getHit();
	public int getRcount();
	public int getPrice();
 */
/*
 * public int getCno();
	public String getTitle();
	public String getPoster();
	public String getIntro();
	public String getAddr();
	public String getDonm();
	public String getManagesttus();
	public int getOperpdcl();
	public int getInduty();
	public int getLctcl();
	public int getHit();
	public int getRcount();
	public double getMapx();
	public double getMapy();
	public int getPrice();
 */
@Repository
public interface CampRepository extends JpaRepository<CampEntity, Integer>{
	@Query(value = "SELECT cno,title,poster,intro,donm,managesttus,hit,rcount,price "
			+ "FROM camp ORDER BY cno LIMIT :start,:rows",nativeQuery = true)
	public List<CampListVO> campListData(@Param("start") Integer start,@Param("rows") Integer rows);
	
	@Query(value = "SELECT cno,title,poster,intro,addr,donm,managesttus,operpdcl,induty,lctcl,hit,rcount,mapx,mapy,price "
			+ "FROM camp WHERE cno=:cno",nativeQuery = true)
	public CampDetailVO campDetailData(@Param("cno") int cno);
	public CampEntity findByCno(int cno);
	
	@Query(value = "SELECT cno,title,poster,intro,donm,managesttus,hit,rcount,price "
			+ "FROM camp WHERE title LIKE CONCAT('%',:fd,'%') ORDER BY cno "
			+ "LIMIT :start,:rows",nativeQuery = true)
	public List<CampListVO> campFindData(@Param("start") Integer start,@Param("rows") Integer rows,@Param("fd") String fd);
	
	@Query(value = "SELECT COUNT(*) "
			+ "FROM camp WHERE title LIKE CONCAT('%',:fd,'%')",nativeQuery = true)
	public int campFindCount(@Param("fd") String fd);
}

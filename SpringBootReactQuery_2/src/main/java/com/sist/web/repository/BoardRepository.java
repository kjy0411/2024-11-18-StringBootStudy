package com.sist.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.entity.*;
@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{
	@Query(value = "SELECT no,subject,name,TO_CHAR(content) as content,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
			+ "FROM (SELECT no,subject,name,content,regdate,hit,rownum as num "
			+ "FROM (SELECT no,subject,name,content,regdate,hit "
			+ "FROM board ORDER BY no DESC)) "
			+ "WHERE num BETWEEN :start AND :end",nativeQuery = true)
	public List<BoardVO> boardListDate(@Param("start") Integer start,@Param("end") Integer end);
	// @Query => 입력되는 데이터가 있는 경우 => @Param
	// @Param 두개 이상 => Integer로 사용
	@Query(value = "SELECT no,subject,name,TO_CHAR(content) as content,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,rownum as num "
			+ "FROM board WHERE no=:no",nativeQuery = true)
	public BoardVO boardDetailData(@Param("no") int no);
	
	@Query(value = "SELECT NVL(MAX(no)+1,1) FROM board",nativeQuery = true)
	public int maxNo();
	
	public BoardEntity findByNo(int no);
	
	@Query(value = "SELECT no,subject,name,TO_CHAR(content) as content "
			+ "FROM board WHERE no=:no",nativeQuery = true)
	public BoardUpdateVO boardUpdateData(@Param("no") int no);
}

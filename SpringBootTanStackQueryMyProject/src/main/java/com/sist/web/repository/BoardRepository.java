package com.sist.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.entity.*;
import com.sist.web.vo.*;
@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{
	@Query(value = "SELECT no,id,name,subject,DATE_FORMAT(regdate,'%Y-%m-%d') as dbday,hit "
			+ "FROM board2 ORDER BY no DESC "
			+ "LIMIT :start,10",nativeQuery = true)
	public List<BoardVO> boardListData(@Param("start") int start);
	
	@Query(value = "SELECT no,id,name,subject,content,DATE_FORMAT(regdate,'%Y-%m-%d %H:%i:%s') as dbday,hit FROM board2 WHERE no=:no",nativeQuery = true)
	public BoardVO boardDetailData(@Param("no") int no);
	
	public BoardEntity findByNo(int no);
	
}

package com.sist.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.entity.*;
import com.sist.web.vo.*;
@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer>{
	@Query(value = "SELECT no,type,bno,id,name,msg,DATE_FORMAT(regdate,'%Y-%m-%d %H:%i:%s') as dbday "
			+ "FROM comment WHERE type=:type AND bno=:bno ORDER BY no DESC "
			+ "LIMIT :start,10",nativeQuery = true)
	public List<CommentVO> commentListData(@Param("type") int type,@Param("bno") int bno, @Param("start") int start);
	@Query(value = "SELECT COUNT(*) FROM comment "
			+ "WHERE type=:type AND bno=:bno",nativeQuery = true)
	public int commentCount(@Param("type") int type, @Param("bno") int bno);
	
	@Query(value = "SELECT IFNULL(MAX(no)+1,1) FROM comment",nativeQuery = true)
	public int MaxNo();
	
	public CommentEntity findByNo(int no);
}

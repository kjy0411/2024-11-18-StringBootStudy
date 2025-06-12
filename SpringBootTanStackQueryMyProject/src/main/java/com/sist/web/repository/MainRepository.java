package com.sist.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.entity.*;
import com.sist.web.vo.*;
@Repository
public interface MainRepository extends JpaRepository<MemberEntity, String>{
	@Query(value = "SELECT COUNT(*) FROM p_member "
			+ "WHERE id=:id",nativeQuery = true)
	public int idCount(@Param("id") String id);
	
	@Query(value = "SELECT id,pwd,name,sex FROM p_member "
			+ "WHERE id=:id",nativeQuery = true)
	public MemberEntity memberData(@Param("id") String id);
}

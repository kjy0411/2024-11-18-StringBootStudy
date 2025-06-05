package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.entity.*;
@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Integer>{
	@Query(value = "SELECT no,poster,title,chef,hit,likecount,num "
			+ "FROM (SELECT no,poster,title,chef,hit,likecount,rownum as num "
			+ "FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk)*/no,poster,title,chef,hit,likecount "
			+ "FROM recipe WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipeDetail))) "
			+ "WHERE num BETWEEN :start AND :end",nativeQuery = true)
	public List<RecipeVO> recipeListData(@Param("start") Integer start, @Param("end") Integer end);
	
	@Query(value = "SELECT CEIL(COUNT(*)/12.0) FROM recipe "
			+ "WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipeDetail)",nativeQuery = true)
	public int recipeTotalPage();
	
	public RecipeEntity findByNo(int no);
	
	// Find
	@Query(value = "SELECT no,poster,title,chef,hit,likecount,num "
			+ "FROM (SELECT no,poster,title,chef,hit,likecount,rownum as num "
			+ "FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk)*/no,poster,title,chef,hit,likecount "
			+ "FROM recipe WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipeDetail) "
			+ "AND title LIKE '%'||:title||'%')) "
			+ "WHERE num BETWEEN :start AND :end",nativeQuery = true)
	public List<RecipeVO> recipeFindData(@Param("start") Integer start,
				@Param("end") Integer end,@Param("title") String title);
	@Query(value = "SELECT CEIL(COUNT(*)/12.0) FROM recipe "
			+ "WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipeDetail) "
			+ "AND title LIKE '%'||:title||'%'",nativeQuery = true)
	public int recipeFindTotalPage(@Param("title") String title);
	// Chef
	// Chef의 recipe목록
	// CRUD
}

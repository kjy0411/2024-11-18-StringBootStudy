package com.sist.web.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.*;
@Repository
@Mapper
public interface FoodMapper {
  /*
   *   <select id="foodListData" resultType="com.sist.web.vo.FoodVO" parameterType="hashmap">
	    SELECT fno,name,poster,score,num 
	    FROM (SELECT fno,name,poster,score,rownum as num 
	    FROM (SELECT fno,name,poster,score 
	    FROM project_food ORDER BY fno ASC))
	    WHERE num BETWEEN #{start} AND #{end}
	  </select>
	  <select id="foodTotalPage" resultType="int">
	    SELECT CEIL(COUNT(*)/12.0) FROM project_food
	  </select>
   */
	public List<FoodVO> foodListData(Map map);
	public int foodTotalPage();
}
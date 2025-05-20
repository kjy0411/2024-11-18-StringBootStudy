package com.sist.web.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.entity.*;
@Repository
public interface BusanInfoRepository extends ElasticsearchRepository<BusanInfoEntity, Integer>{
	// SELECT * FROM table_name , INSERT / UPDATE / DELETE => 이미 만들어져있다
	// WHERE (조건문) X => 규칙에 따라 직접 생성 => findByNo... => 메소드 패턴
	// < : lessthen, > : greaterthen, <= : lessthenEqual, >= greaterthenEqual
	public List<BusanInfoEntity> findByCno(@Param("cno") Integer cno);
	public List<BusanInfoEntity> findByTitleContaining(@Param("title") String title);
	/*  
	 * 	LIKE
	 *  A%	findByTitleStartsWith
	 *  %A	findByTitleEndsWith
	 *  %A%	findByTitleContaining
	 */
}

package com.sist.web.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import java.util.*;
import com.sist.web.vo.EBusanFood;
/*
 *  JPA 형식 => 메소드 제작
 *  select distinct ... where lastname and firstname
 *  
 *  => findDistinctByLastnameAndFirstName()
 *  
 *  where no between ... and ...
 *  
 *  => findByNoBetween(int a,int b)
 *  
 *  where age<?
 *  
 *  => findByAgeLassThen(int age)
 *  			----
 *  <	: LassThen
 *  >	: GreaterThen
 *  <=	: LassThenEqual
 *  >=	: GreaterThenEqual
 *  가격(price) 1000보다 작고 가격 => 내림차순
 *  => findByPriceLassThenOrderBYPriceDESC(1000)
 *  
 *  @Query({hits:hits:{_source:{type:'*0?*'}}})
 */
public interface EBusanFoodRepository extends ElasticsearchRepository<EBusanFood, Integer>{
	public List<EBusanFood> findByTypeContaining(String type); // LIKE '%'||#{type}||'%'
	// 메소드화 => 조건이 있는 경우 / Order By , Group by ....
	// JOIN => 메소드(X)
	public EBusanFood findById(String id);
}

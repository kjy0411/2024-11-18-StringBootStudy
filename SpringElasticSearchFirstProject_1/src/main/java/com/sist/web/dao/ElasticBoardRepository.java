package com.sist.web.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.ElasticBoard;

/*  
 *  A%, B%, %C%
 *  findByNameStartWith(String name) => A%
 *  findByNameEndWith(String name) => B%
 *  findByNameContaining(String name) => C%
 *  
 */
@Repository
public interface ElasticBoardRepository extends ElasticsearchRepository<ElasticBoard, Integer>{
	public ElasticBoard findById(int id); // SELECT * FROM board WHERE id=?
	
	// CRUD설정
	/*  Default 생성
	 *  findAll() => 전체 데이터 읽기
	 *  findBy컬럼명() => 상세보기
	 *  save() => insert/update
	 *  delete() => delete
	 *  
	 *  mybatis / hibernate
	 *    | SQL기반  | 메소드 => 자동으로 SQL문장을 제작
	 *    	------	  ---- 형식
	 *    		|		| 단점 : JOIN (O), subquery는 없다
	 *    		|		| ~Entity (컬럼과 일치)
	 *  		| ~VO (다른 데이터 추가 가능)
	 *    
	 */
}

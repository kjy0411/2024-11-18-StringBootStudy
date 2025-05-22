package com.sist.web.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.vo.*;
// 혼합 제공된 메서드 사용 or 직접 sql문 작성후 사용 가능
// 단점 : 가독성이 떨어진다, 소스가 간결하다, SQL을 몰라도 처리가 가능하다
// => JSP, SQL
@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer>{
	// CRUD => update/insert => save() , delete => delete()
	// fincAll(), count()
	// 조건처리(X)
	// ElasticSearch => NoSQL => JSON (MongDB, 카산드라...)
	// 컬럼의 갯수가 명확한 경우, 명확하지 않은 경우
	@Query(value = "SELECT * FROM emp",nativeQuery = true)
	public List<Emp> empAllData();
	// SELECT * FROM EMP WHERE empno=?
	public Emp findByEmpno(int empno);
	//		   ----  -----	   -----
	//			WHERE empno=?
	//public List<Emp> findByEnameContaining(String ename);
	//				 WHERE ename Like '%?%'
	//public List<Emp> findByEnameStartsWith(String ename);
	//			WHERE ename Like '?%'
	// SELECT DISTINCT job FROM emp
	//public List<Emp> findDistinctByJob();
	// find => SLECT , By => WHERE
	// SELECT * FROM emp WHERE sal>? sal<? sal<= sal>=?
	/* 
	 *  findBySalLessThen (sal<?)	findBySalGraterThen(sla>?)
	 *  findBySalLessThenEqual (sal<=?)	findBySalGraterThenEqual(sla>=?)
	 *  
	 *  => SELECT * FROM emp ORDER BY sal
	 *  
	 *  findBySalOrderBy
	 *  
	 *  => 규칙에 따라 메소드 생성시 자동으로 SQL문 생성
	 *  
	 *  SELECT e FROM EMP e;
	 *  SELECT e.empno,e.ename FROM EMP e;
	 *  
	 */
}

package com.sist.web.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.vo.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import com.sist.web.dao.*;
@Controller
public class EmpController {
	@Autowired
	private EmpRepository eDao;
	
	@Autowired
	private EntityManager em; // 조인시에 필요한 클래스
	
	@GetMapping("/emp/list")
	public String emp_list(Model model) {
		//List<Emp> list=eDao.empAllData();
		List<Emp> list=eDao.findAll(Sort.by(Sort.Direction.DESC,"sal"));
		// Page<Emp> => 페이지를 나눠서 처리
		// 사용자 정의 @Query 
		model.addAttribute("list",list);
		return "emp/list";
	}
	@GetMapping("/emp/detail")
	public String getMethodName(@RequestParam("empno") int empno,Model model) {
		String sql="SELECT s FROM Emp s JOIN s.dept d WHERE s.empno=:empno";
		Emp e=em.createQuery(sql,Emp.class).setParameter("empno", empno).getSingleResult();
		// getResults() : List, getSingleResult() : VO
		//Emp emp=eDao.findByEmpno(empno);
		model.addAttribute("vo",e);
		return "emp/detail";
	}
	/*  
	 *  JPA
	 *  	= 메소드 규칙
	 *  	= @Query 사용법
	 *  	= JOIN
	 */
	@GetMapping("/emp/join")
	public String emp_join(Model model) {
		// JPQL구사
		String sql="SELECT s FROM Emp s JOIN Fetch s.dept";
		TypedQuery<Emp> query=em.createQuery(sql,Emp.class);
		List<Emp> list=query.getResultList();
		model.addAttribute("list",list);
		return "emp/join";
	}
	
	
}

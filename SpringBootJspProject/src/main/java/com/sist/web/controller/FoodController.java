package com.sist.web.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.vo.*;
import com.sist.web.service.*;
// => Maven / Gradle => 프로젝트 관리, 라이브러리 관리, 버전 관리, 배포 관리
// => 원격 : git / svn => 형상관리
// => 브런치
// => 협업
// 50:50 => 인사부 / 개발부
// 일관성
/*  
 *  1. 웹 흐름, 데이터베이스 연동 : CRUD
 *  2. 스프링 / MVC 구조
 *  3. 최신 기술 => CI/CD
 *  
 *  => 프로젝트 구현
 *     ---------- 과정 중시 => 산출물, 협업 (문제점 / 해결책)
 */
@Controller
public class FoodController {
  @Autowired
  private FoodService fService;
  
  @GetMapping("/list")
  public String food_list(@RequestParam(name="page",required = false) String page,Model model)
  {
	  if(page==null)
		  page="1";
	  int curpage=Integer.parseInt(page);
	  Map map=new HashMap();
	  map.put("start", (curpage*12)-11);
	  map.put("end", curpage*12);
	  List<FoodVO> list=fService.foodListData(map);
	  int totalpage=fService.foodTotalPage();
	  
	  final int BLOCK=10;
	  int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	  int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	  if(endPage>totalpage)
		  endPage=totalpage;
	  
	  model.addAttribute("list", list);
	  model.addAttribute("curpage", curpage);
	  model.addAttribute("totalpage", totalpage);
	  model.addAttribute("startPage", startPage);
	  model.addAttribute("endPage", endPage);
	  return "list";
  }
}
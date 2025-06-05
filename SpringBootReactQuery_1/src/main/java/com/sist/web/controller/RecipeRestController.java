package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.entity.*;
import com.sist.web.service.*;
// const {isLoading,error,data}=useQuery() => 3 => tanStack-Query : 기능 추가
//												   오픈 소스 그룹
// 일반 => 권장 : JavaScript / TypeScript (가독성)
// Redux => TanStack-Query => ThymeLeaf (Git Actions , Docker)
@RestController
@CrossOrigin(origins = "*")
public class RecipeRestController {
	@Autowired
	private RecipeService service;
	
	@GetMapping("/recipe/list/{page}")
	public ResponseEntity<Map> recipe_list(@PathVariable("page") int page) {
		Map map = new HashMap();
		try {
			int rowSize=12;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			List<RecipeVO> list=service.recipeListData(start, end);
			int totalpage=service.recipeTotalPage();
			
			final int BLOCK=10;
			int startPage=((page-1)/BLOCK*BLOCK)+1;
			int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
			if (endPage>totalpage)
				endPage=totalpage;
			
			map.put("fList", list);
			map.put("curpage", page);
			map.put("totalpage", totalpage);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK); // 정상 수행 => 200
	}
	
	@GetMapping("/recipe/detail/{no}")
	public ResponseEntity<Map> recipe_detail(@PathVariable("no") int no) {
		Map map=new HashMap();
		try {
			map=service.recipeDetailData(no);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	@GetMapping("/recipe/find/{page}/{title}")
	public ResponseEntity<Map> getMethodName(@PathVariable("page") int page,@PathVariable("title") String title) {
		Map map=new HashMap();
		try {
			map=service.recipeFindData(page, title);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
}

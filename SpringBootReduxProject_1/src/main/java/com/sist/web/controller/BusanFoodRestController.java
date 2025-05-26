package com.sist.web.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.vo.*;
import com.sist.web.dao.*;
@RestController
@CrossOrigin(origins = "*")
public class BusanFoodRestController {
	@Autowired
	public BusanFoodRepository bDao;
	
	@GetMapping("/food/list_react")
	public Map food_list(@RequestParam(name = "page") int page){
		int rowSize=12;
		int start=(rowSize*page)-rowSize;
		// LIMIT => 0번 시작
		List<BusanFoodVO> list=bDao.busanFoodList(start);
		int count=(int)bDao.count();
		int totalpage=(int)(Math.ceil(count/12.0));
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		Map map=new HashMap();
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		return map;
	}
}

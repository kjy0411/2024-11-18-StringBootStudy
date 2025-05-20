package com.sist.web.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.*;


import com.sist.web.entity.*;
/*  
 *  서버 => 클라이언트 통신							모바일 (코틀린)
 *  서버 = 클라이언트와 동일한 언어						  | JSON
 *  ------------- 언어가 다른 경우 파이썬 == 장고, 스프링 == 자바,  C# == Asp.net
 *  						자바스크립트 : 인식 불가 => 모든 언어에 호환되는 XML,JSON 사용 
 */
@RestController
@CrossOrigin("*")
public class BusanInfoRestController {
	@Autowired
	private BusanInfoService bService;
	
	@GetMapping("/main_react")
	public Map main_react() {
		List<BusanInfoEntity> list1=bService.getBusanInfoData(1);
		List<BusanInfoEntity> list2=bService.getBusanInfoData(2);
		List<BusanInfoEntity> list3=bService.getBusanInfoData(3);
		
		Map map=new HashMap();
		map.put("list1", list1);
		map.put("list2", list2);
		map.put("list3", list3);
		
		return map; // JSON 자동변환
	}
	@GetMapping("/info/list_react")
	public Map info_list(@RequestParam("page") int page) {
		List<BusanInfoEntity> list=bService.getBusanInfoAll(page);
		int[] data=bService.getPageDatas(page);
		
		Map map=new HashMap();
		map.put("list", list);
		map.put("pages", data);
		return map;
	}
	
	@RequestMapping("/info/find_react")
	public Map info_find(String title) {
		if(title==null)
			title="부산";
		List<BusanInfoEntity> list=bService.busanInfoFindData(title);
		Map map=new HashMap();
		map.put("list", list);
		return map;
	}
}

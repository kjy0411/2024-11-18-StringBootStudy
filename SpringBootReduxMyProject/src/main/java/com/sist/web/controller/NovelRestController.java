package com.sist.web.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.*;
import com.sist.web.entity.*;
@RestController
@CrossOrigin(origins = "*")
public class NovelRestController {
	@Autowired
	private NovelService service;
	
	@GetMapping("/main")
	public Map main_data() {
		Map map=new HashMap();
		List<NovelEntity> list=service.mainNovelData();
		map.put("list", list);
		return map;
	}
	
	@GetMapping("/novel/list_react")
	public Map novel_list(@RequestParam("page") int page) {
		Map map=new HashMap();
		int rowSize=12;
		int start=(page-1)*rowSize;
		List<NovelEntity> list=service.novelListData(start);
		int totalpage=service.novelTotalPage();
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		return map;
	}
	
	@GetMapping("/novel/detail_react")
	public NovelEntity nobel_detail(@RequestParam("no") int no) {
		NovelEntity vo=service.novelDetailAndHit(no);
		return vo;
	}
	
	@GetMapping("/novel/find_react")
	public Map novel_find(@RequestParam("fd") String fd,@RequestParam("genre") String genre,@RequestParam("page") int page) {
		Map map=new HashMap();
		int rowSize=12;
		int start=(page-1)*rowSize;
		List<NovelEntity> list=service.novelFindByFdGenre(fd,genre,start);
		int totalpage=service.novelFindTotalPage(fd,genre);
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		return map;
	}
	
	@GetMapping("/novel/serial_react")
	public Map novel_serial(@RequestParam("serial") String serial,@RequestParam("page") int page) {
		Map map=new HashMap();
		int rowSize=12;
		int start=(page-1)*rowSize;
		List<NovelEntity> list=service.novelListBySerial(serial, start);
		int totalpage=service.novelTotalPageBySerial(serial);
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		return map;
	}
	
}

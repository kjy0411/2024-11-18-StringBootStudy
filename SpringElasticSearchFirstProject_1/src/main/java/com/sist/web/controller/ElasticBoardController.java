package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import com.sist.web.vo.*;
import com.sist.web.dao.*;
@Controller
public class ElasticBoardController {
    @Autowired
    private ElasticBoardRepository bDao;
    // *.do  /
    @GetMapping("/eboard/list")
    public String eboard_list(@RequestParam(name = "page",required = false) String page,Model model)
    {
    	if(page==null)
    		page="1";
    	int curpage=Integer.parseInt(page);
    	int rowSize=10;
    	Pageable pg=PageRequest.of(curpage-1, rowSize,Sort.by(Sort.Direction.DESC,"id"));
    	//   전체 데이터 읽기 => findAll => SELECT ~~ 
    	Page<ElasticBoard> pList=bDao.findAll(pg);
    	// Page => List로 변환 
    	List<ElasticBoard> list=new ArrayList<ElasticBoard>();
    	if(pList!=null && pList.hasContent())
    	{
    		list=pList.getContent(); // Page => List변환 
    	}
    	
    	ElasticBoard eb=list.get(0);
    	String s=eb.getRegdate();
    	s=s.substring(0,s.indexOf("T")); // %Y-%m-%d TO_CHAR
    	list.get(0).setRegdate(s);
    	// 총페이지 구하기 
    	int count=(int)bDao.count();
    	int totalpage=(int)(Math.ceil(count/10.0));
    	
    	// HTML로 전송 
    	/*
    	 *   findAll() : SELECT * FROM board
    	 *   findById(int id) : SELECT * FROM board WHERE id=?
    	 *   count() : SELECT COUNT(*) FROM board
    	 *   save() : insert , update 
    	 *   delete() : delete
    	 */
        model.addAttribute("curpage", curpage);
        model.addAttribute("totalpage", totalpage);
        model.addAttribute("list", list);
        
    	return "eboard/list";
    }
}
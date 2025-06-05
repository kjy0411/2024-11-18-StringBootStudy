package com.sist.web.controller;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.entity.*;
import com.sist.web.service.*;

@RestController
// => Reatful => GET(SELECT 읽기), POST(INSERT 쓰기) , PUT(UPDATE 수정) , DELETE(DELETE 삭제)
@CrossOrigin(origins = "*")
// 1521 / 8080 => AWS는 0~1023까지 port를 접근 거부
public class BoardRestController {
	@Autowired
	private BoardService service;
	// ResponseEntity<Map>
	@GetMapping("/board/list_react/{page}")
	public Map board_list(@PathVariable("page") int page) {
		Map map=new HashMap();
		int rowSize=10;
		int start=(page-1)*rowSize;
		List<BoardEntity> list=service.boardListDate(start);
		for(BoardEntity vo:list) {
			String day=vo.getRegdate();
			day=day.substring(0,day.indexOf(" "));
			vo.setRegdate(day);
		}
		int count=(int)service.count();
		int totalpage=(int)(Math.ceil(count/(double)rowSize));
		String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		System.out.println(map.toString());
		System.out.println(startPage);
		System.out.println(endPage);
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("today", today);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		return map;
	}
	@PostMapping("/board/insert_react")
	public Map board_insert(@RequestBody BoardEntity vo) {
		Map map=new HashMap();
		try {
			vo.setHit(0);
			BoardEntity _vo=service.save(vo);
			map.put("vo", _vo);
			map.put("msg", "yes");
		} catch (Exception e) {
			map.put("msg", e.getMessage());
		}
		return map;
	}
	/*
	 *  	JPA => DataSet => VO를 가지고 데이터베이스 제어
	 *  			|
	 *  			SQL없이 사용이 가능
	 *  	=> 복잡한 쿼리, WHERE (조건문) => 규칙
	 *  	   findByNo(int no) WHERE no=?
	 *  	=> 나머지는 제공하는 메소드 사용
	 *  		= count() SELECT COUNT(*) ~
	 *  		= save() => insert/update
	 *  		= delete()
	 */
	@GetMapping("/board/detail_react/{no}")
	public BoardEntity board_detail(@PathVariable("no") int no) {
		BoardEntity vo=service.findByNo(no);
		// 조회수 증가
		vo.setHit(vo.getHit()+1);
		service.save(vo);
		vo=service.findByNo(no);
		return vo;
	}
	@DeleteMapping("/board/delete_react/{no}/{pwd}")
	public Map board_delete(@PathVariable("no") int no, @PathVariable("pwd") String pwd) {
		Map map=new HashMap();
		BoardEntity vo=service.findByNo(no);
		if(vo.getPwd().equals(pwd)) {
			service.delete(vo);
			map.put("msg", "yes");
		}else {
			map.put("msg", "no");
		}
		return map;
	}
	@GetMapping("/board/update_react/{no}")
	public BoardEntity board_update(@PathVariable("no") int no) {
		return service.findByNo(no);
	}
	@PutMapping("/board/update_ok_react")
	public Map board_update_ok(@RequestBody BoardEntity vo) {
		Map map=new HashMap();
		BoardEntity db=service.findByNo(vo.getNo());
		if(vo.getPwd().equals(db.getPwd())) {
			vo.setNo(vo.getNo());
			vo.setHit(db.getHit());
			service.save(vo);
			map.put("msg", "yes");
		}else {
			map.put("msg", "no");
		}
		return map;
	}
	
}

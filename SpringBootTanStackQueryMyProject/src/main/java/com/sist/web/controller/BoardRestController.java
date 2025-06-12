package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.service.*;
import com.sist.web.entity.*;
import com.sist.web.vo.*;
@RestController
@CrossOrigin(origins = "*")
public class BoardRestController {
	@Autowired
	private BoardService service;
	
	@GetMapping("/board/list/{page}")
	public ResponseEntity<Map> board_list(@PathVariable("page") int page) {
		Map map=new HashMap();
		try {
			map=service.boardListData(page);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	@GetMapping("/board/detail/{no}")
	public ResponseEntity<Map> board_detail(@PathVariable("no") int no) {
		Map map=new HashMap();
		try {
			map=service.boardDetailData(no);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	// 등록
	@PostMapping("/board/insert")
	public ResponseEntity<Map> board_insert(@RequestBody BoardEntity vo) {
		Map map=new HashMap();
		try {
			service.boardInsert(vo);
			map.put("msg", "ok");
		} catch (Exception e) {
			return new ResponseEntity<Map>(map,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	// 삭제
	@DeleteMapping("/board/delete/{no}")
	public ResponseEntity<Map> board_delete(@PathVariable("no") int no) {
		Map map=new HashMap();
		try {
			service.boardDelete(no);
			map.put("msg", "ok");
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	@GetMapping("/board/update/{no}")
	public ResponseEntity<Map> board_update_date(@PathVariable("no") int no) {
		Map map=new HashMap();
		try {
			map=service.boardUpdateData(no);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	@PutMapping("/board/update_ok")
	public ResponseEntity<Map> board_update(@RequestBody BoardEntity vo) {
		Map map=new HashMap();
		try {
			service.boardUpdate(vo);
			map.put("msg", "ok");
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}

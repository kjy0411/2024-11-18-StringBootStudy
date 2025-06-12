package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.service.*;
import com.sist.web.entity.*;
import com.sist.web.vo.*;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin(origins = "*")
public class CampRestController {
	@Autowired
	private CampService service;
	
	@GetMapping("/camp/list/{page}/{rows}")
	public ResponseEntity<Map> camp_list(@PathVariable("page") int page, @PathVariable("rows") int rows){
		Map map=new HashMap();
		try {
			map=service.campListData(page, rows);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	@GetMapping("/camp/detail/{cno}/{hc}")
	public ResponseEntity<Map> camp_detail(@PathVariable("cno") int cno,@PathVariable("hc") int hc) {
		Map map=new HashMap();
		try {
			map=service.campDetailData(cno,hc);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	@GetMapping("/camp/find/{page}/{rows}/{fd}")
	public ResponseEntity<Map> camp_find(@PathVariable("page") int page, @PathVariable("rows") int rows,@PathVariable("fd") String fd){
		Map map=new HashMap();
		try {
			map=service.campFindData(page, rows, fd);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}

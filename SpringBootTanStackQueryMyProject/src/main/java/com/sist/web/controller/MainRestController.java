package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.service.*;
import com.sist.web.entity.*;
import com.sist.web.vo.*;
@RestController
@CrossOrigin(origins = "*")
public class MainRestController {
	@Autowired
	private MainService mService;
	
	@PostMapping("/member/login")
	public ResponseEntity<Map> memberLogin(@RequestBody MemberEntity vo) {
		Map map=new HashMap();
		try {
			map=mService.memberLogin(vo.getId(),vo.getPwd());
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}

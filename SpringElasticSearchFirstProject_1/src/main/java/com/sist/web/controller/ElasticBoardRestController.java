package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.vo.*;
import com.sist.web.dao.*;
@RestController
public class ElasticBoardRestController {
	@Autowired
	private ElasticBoardRepository bDao;
	
	@PostMapping("/eboard/update_ok")
    public String eboard_update_ok(ElasticBoard vo) {
    	// id / name / subject / content / pwd => hit , regdate
    	String result="";
    	ElasticBoard dbvo=bDao.findById(vo.getId());
    	if(dbvo.getPwd().equals(vo.getPwd())) {
    		vo.setHit(dbvo.getHit());
    		vo.setRegdate(dbvo.getRegdate());
    		bDao.save(vo); // update => 요소를 모두 채우지 않으면 0,null 값이 들어간다
    		result="<script>"
    			+ "location.href=\"/eboard/detail?id="+vo.getId()+"\""
    			+ "</script>";
    	}else {
    		result="<script>"
    			+ "alert(\"비밀번호가 틀립니다\")\n"
    			+ "history.back()"
    			+ "</script>";
    	}
    	return result; // Controller => return값 : 이동 정보
    }
	@PostMapping("/eboard/delete_ok")
	// 가급적 => AJAX / VUE
	public String eboard_delete_ok(@RequestParam("id") int id,@RequestParam("pwd") String pwd) {
		String result="";
		ElasticBoard vo=bDao.findById(id);
		if(pwd.equals(vo.getPwd())) {
			bDao.delete(vo);
			result="<script>"
    			+ "location.href=\"/eboard/list\""
    			+ "</script>";
		}else {
			result="<script>"
    			+ "alert(\"비밀번호가 틀립니다\")\n"
    			+ "history.back()"
    			+ "</script>";
		}
		return result;
	}
	
}

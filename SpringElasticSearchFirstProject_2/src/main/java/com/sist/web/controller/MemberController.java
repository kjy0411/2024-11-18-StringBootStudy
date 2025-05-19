package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.*;
import com.sist.web.vo.*;
import com.sist.web.service.*;
//Thymeleaf 이용
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class MemberController {
	@Autowired
	private MemberService mService;
	
	@GetMapping("/member/list")
	public String member_list(Model model) {
		Iterable<Member> iter=mService.getAllMembers();
		List<Member> list=new ArrayList<Member>();
		// Iterable => List 변환
		iter.forEach(list::add);
		model.addAttribute("list",list);
		return "member/list";
	}
	@GetMapping("/member/insert")
	public String memeber_insert() {
		return "member/insert";
	}
	@PostMapping("/member/insert_ok")
	public String member_insert_ok(Member member) {
		mService.saveMember(member);
		return "redirect:/member/list";
	}
	@GetMapping("/member/detail")
	public String member_detail(@RequestParam("id") String id,Model model) {
		Member member=mService.getMemberId(id);
		model.addAttribute("vo",member);
		return "member/detail";
	}
	@GetMapping("/member/delete")
	public String member_delte(@RequestParam("id") String id) {
		Member member=mService.getMemberId(id);
		mService.deleteMember(member);
		return "redirect:/member/list";
	}
	
	
	
	
}

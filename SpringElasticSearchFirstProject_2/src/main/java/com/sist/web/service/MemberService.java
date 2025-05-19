package com.sist.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.web.vo.*;
import com.sist.web.dao.*;
// JPA방식 => 1. return형, 2. 매개변수, 3. 메소드명 => 자동지정
// 필요시에 의하면 메소드 규칙에 따라 제작
// WHERE 문장 => findBy변수명명령어 where name like => less then, greater then
// SQL문장이 필요시에는 반드시 native query
@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	//저장
	public void saveMember(Member member) {
		memberRepository.save(member);
	}
	//삭제
	public void deleteMember(Member member) {
		memberRepository.delete(member);
	}
	//전체 검색
	public Iterable<Member> getAllMembers(){
		return memberRepository.findAll();
	}
	public Member getMemberId(String id) {
		return memberRepository.findById(id).orElse(null);
	}
}

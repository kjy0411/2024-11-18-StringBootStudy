package com.sist.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.web.repository.*;
import com.sist.web.entity.*;
import com.sist.web.vo.*;
@Service
public class MainServiceImpl implements MainService{
	@Autowired
	private MainRepository mDao;
	@Autowired
	private CampRepository cDao;

	@Override
	public int idCount(String id) {
		return mDao.idCount(id);
	}

	@Override
	public Map memberLogin(String id,String pwd) {
		Map map=new HashMap();
		
		int count=idCount(id);
		if(count==0) {
			map.put("msg", "NOID");
		}else { // id가 있는 경우
			MemberEntity vo=mDao.memberData(id);
			if(pwd.equals(vo.getPwd())) { // 비밀번호 일치
				map.put("msg", "OK");
				map.put("name", vo.getName());
				map.put("id", vo.getId());
			}else { // 비밀번호 불일치
				map.put("msg", "NOPWD");
			}
		}
		return map;
	}

	@Override
	public List<CampListVO> mainCampData() {
		return cDao.mainCampData();
	}
	
	
}

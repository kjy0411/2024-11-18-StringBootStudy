package com.sist.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.web.entity.*;
import com.sist.web.dao.*;
@Service
public class BusanInfoService {
	@Autowired
	private BusanInfoRepository bDao;
	
	public List<BusanInfoEntity> getBusanInfoData(int cno){
		List<BusanInfoEntity> list=bDao.findByCno(cno);
		List<BusanInfoEntity> list2=new ArrayList<BusanInfoEntity>();
		for(int i=0;i<8;i++) {
			list2.add(list.get(i));
		}
		return list2;
	}
}

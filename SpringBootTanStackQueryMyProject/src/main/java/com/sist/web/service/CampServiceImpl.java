package com.sist.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.web.repository.*;
import com.sist.web.commons.*;
import com.sist.web.entity.*;
import com.sist.web.vo.*;
@Service
public class CampServiceImpl implements CampService{
	@Autowired
	private CampRepository cDao;
	@Autowired
	private PageNation pn;
	@Override
	public Map campListData(int page, int rows) {
		Map map=new HashMap();
		int start=(page-1)*rows;
		List<CampListVO> list=cDao.campListData(start, rows);
		int count=(int)cDao.count();
		int totalpage=(int)(Math.ceil(count/(double)rows));
		
		PageVO vo=pn.pageNation(page, totalpage);
		
		map.put("list", list);
		map.put("page", vo);
		return map;
	}

	@Override
	public Map campDetailData(int cno,int hc) {
		Map map=new HashMap();
		if(hc==1) {
			CampEntity vo=cDao.findByCno(cno);
			vo.setHit(vo.getHit()+1);
			cDao.save(vo);
		}
		
		CampDetailVO dvo=cDao.campDetailData(cno);
		map.put("detail", dvo);
		return map;
	}

	@Override
	public Map campFindData(int page, int rows, String fd) {
		Map map=new HashMap();
		int start=(page-1)*rows;
		List<CampListVO> list=cDao.campFindData(start,rows,fd);
		int count=cDao.campFindCount(fd);
		int totalpage=(int)(Math.ceil(count/(double)rows));
		
		PageVO vo=pn.pageNation(page, totalpage);
		
		map.put("list", list);
		map.put("page", vo);
		return map;
	}
}

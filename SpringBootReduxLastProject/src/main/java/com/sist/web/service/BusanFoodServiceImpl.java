package com.sist.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.web.vo.*;
import com.sist.web.entity.*;
import com.sist.web.dao.*;
// 실무 => JPA 40% / Query 60%
@Service
public class BusanFoodServiceImpl implements BusanFoodService{
	@Autowired
	private BusanFoodRepository bDao;
	@Autowired
	private BusanInfoRepository iDao;

	@Override
	public List<BusanFoodVO> busanMainData() {
		List<BusanFoodVO> list=bDao.busanMainData();
		return list;
	}

	@Override
	public List<BusanInfoEntity> busanInfoData() {
		return iDao.busanInfoData();
	}

	@Override
	public List<BusanFoodVO> busanListData(int start) {
		return bDao.busanListData(start);
	}

	@Override
	public int busanFoodTotalPage() {
		return bDao.busanFoodTotalPage();
	}

	@Override
	public BusanFoodEntity foodDetailData(int fno) {
		return bDao.findByFno(fno);
	}

	@Override
	public List<BusanInfoEntity> busanInfoListData(int cno, int start) {
		return iDao.busanInfoListData(cno, start);
	}

	@Override
	public int busanInfoTotalPage(int cno) {
		return iDao.busanInfoTotalPage(cno);
	}

	@Override
	public List<BusanInfoEntity> findByTitleContaining(String title) {
		return iDao.findByTitleContaining(title);
	}

}

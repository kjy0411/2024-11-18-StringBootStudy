package com.sist.web.service;

import java.util.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.*;
import com.sist.web.vo.*;

public interface BusanFoodService {
	public List<BusanFoodVO> busanMainData();
	public List<BusanInfoEntity> busanInfoData();
	public List<BusanFoodVO> busanListData(int start);
	public int busanFoodTotalPage();
	public BusanFoodEntity foodDetailData(int fno);
	public List<BusanInfoEntity> busanInfoListData(int cno,int start);
	public int busanInfoTotalPage(int cno);
	public List<BusanInfoEntity> findByTitleContaining(String title);
	public BusanInfoEntity busanInfoDetailData(int no);
}

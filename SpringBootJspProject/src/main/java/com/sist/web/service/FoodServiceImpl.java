package com.sist.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.mapper.FoodMapper;
import com.sist.web.vo.FoodVO;

@Service
public class FoodServiceImpl implements FoodService{

	@Autowired
	private FoodMapper mapper;
	
	@Override
	public List<FoodVO> foodListData(Map map) {
		return mapper.foodListData(map);
	}

	@Override
	public int foodTotalPage() {
		return mapper.foodTotalPage();
	}

	@Override
	public FoodVO foodDetailData(int fno) {
		return mapper.foodDetailData(fno);
	}

}
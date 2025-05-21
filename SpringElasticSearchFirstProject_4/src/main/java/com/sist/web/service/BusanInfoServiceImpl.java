package com.sist.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.web.vo.*;
import com.sist.web.dao.*;
/*
 *   배민 / 쿠팡 / 카카오 
 *   인터파크 / 코난 => 검색엔진 => elasticsearch 
 *   검색 속도가 필요 ...
 *   NoSQL => CRUD / 검색엔진 => 최적화 
 *   ------------------------------- 데이터를 첨부해야 가능 
 *                                   ----------------- 클러스트이용 => 리눅스 : 암호화 
 *                                   SSH 
 *   
 */
@Service
public class BusanInfoServiceImpl implements BusanInfoService{
	@Autowired
	private BusanInfoRepository bDao;

	@Override
	public List<BusanInfoEntity> busanAllData(int page) {
		int rowSize=12;
		Pageable pg=PageRequest.of(page-1, rowSize,Sort.by(Sort.Direction.ASC,"id"));
		
		Page<BusanInfoEntity> pList=bDao.findAll(pg);
		// List로 변환
		List<BusanInfoEntity> list=new ArrayList<BusanInfoEntity>();
		if(pList!=null && pList.hasContent()) {
			list=pList.getContent();
		}
		return list;
	}
/*  
 *  실무
 *  	DAO:Repository => Only DataBase연동
 *  	Service : 필요한 데이터를 받아서 (DAO) => 요청 처리후에 Controller로 전송
 *  	Controller => Only 브라우저 전송
 *  	=> 최적화 (결합성이 낮은 프로그램)
 *  	=> Spring - Framework
 *  	   ------------------ Spring-Boot
 *  		=> 문서 작업 => 메뉴얼, HTML (CSS) - Front
 *  		=> SM
 *  		   SI
 */
	@Override
	public int[] getPageData(int page) {
		int[] datas=new int[4];
		int count=(int)bDao.count();
		int totalpage=(int)(Math.ceil(count/12.0));
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		datas[0]=page;
		datas[1]=totalpage;
		datas[2]=startPage;
		datas[3]=endPage;
		return datas;
	}

	@Override
	public List<BusanInfoEntity> findByTitleContaining(String title) {
		return bDao.findByTitleContaining(title);
	}

	@Override
	public List<BusanInfoEntity> busanFindData(String title) {
		return bDao.busanFindData(title);
	}

	@Override
	public List<BusanInfoEntity> findByCno(Integer cno) {
		return bDao.findByCno(cno);
	}

	@Override
	public List<BusanInfoEntity> busanCnoData(Integer cno) {
		return bDao.busanCnoData(cno);
	}

	@Override
	public BusanInfoEntity busanDetailData(Integer id) {
		return bDao.busanDetailData(id);
	}

	@Override
	public BusanInfoEntity findById(String id) {
		// Optional<BusanInfoEntity> => VO 객체로 변환
		//BusanInfoEntity b=bDao.findById(id).orElse(new BusanInfoEntity());
		return bDao.findById(id);
	}
	
}

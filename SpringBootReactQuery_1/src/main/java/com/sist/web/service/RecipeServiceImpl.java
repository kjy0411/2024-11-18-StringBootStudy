package com.sist.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.web.entity.*;
import com.sist.web.dao.*;
/*
 * 		DAO : table 한개 담당
 * 		Service : 여러개 table 모아서 담당
 * 				  DAO 여러개
 * 				  DAO와 다른 기능이 있는 경우
 * 		-------------------------------- 의존성이 낮은 프로그램
 * 					| 처리 => 실무에서는
 * 			=> DAO = Service = Controller
 * 				|					|
 * 			데이터베이스 연동		브라우저로 값을 전송
 * 
 * 			=> ㅇDAO / Service의 차이점 => 95%
 * 			이력서 => 1. 기술면접
 * 					2. 코딩 테스트 : 중견 업체
 * 					3. 테스트지
 * 					--------------- 인성면접 ------------- 계약서
 */
@Service
public class RecipeServiceImpl implements RecipeService{
	@Autowired
	private RecipeRepository rDao;
	@Autowired
	private RecipeDetailRepository rdDao;
	
	@Override
	public List<RecipeVO> recipeListData(Integer start, Integer end) {
		return rDao.recipeListData(start, end);
	}

	@Override
	public int recipeTotalPage() {
		return rDao.recipeTotalPage();
	}

	@Override
	public Map recipeDetailData(int no) {
		Map map=new HashMap();
		
		RecipeDetailEntity vo=rdDao.findByNo(no);
		String[] datas=vo.getFoodmake().split("\n");
		List<String> mList=new ArrayList<String>();
		List<String> iList=new ArrayList<String>();
		
		for(String d:datas) {
			StringTokenizer st=new StringTokenizer(d,"^");
			mList.add(st.nextToken());
			iList.add(st.nextToken());
		}
		
		String s=vo.getData();
		s=s.replace("[구매]", "");
		vo.setData(s);
		String[] arr=s.split(",");
		List<String> dList=Arrays.asList(arr);
		
		map.put("vo", vo);
		map.put("dList", dList);
		map.put("mList", mList);
		map.put("iList", iList);
		
		return map;
	}

	@Override
	public Map recipeFindData(int page, String title) {
		Map map=new HashMap();
		
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		List<RecipeVO> list=rDao.recipeFindData(start, end, title);
		int totalpage=rDao.recipeFindTotalPage(title);
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if (endPage>totalpage)
			endPage=totalpage;
		
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		return map;
	}
	
}

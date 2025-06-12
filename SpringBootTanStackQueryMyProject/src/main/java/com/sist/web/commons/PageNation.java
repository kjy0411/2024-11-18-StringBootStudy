package com.sist.web.commons;

import org.springframework.stereotype.Component;
import java.util.*;
import com.sist.web.vo.*;
@Component
public class PageNation {
	
	public PageVO pageNation(int page,int totalpage) {
		PageVO vo=new PageVO();
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		vo.setCurpage(page);
		vo.setTotalpage(totalpage);
		vo.setStartPage(startPage);
		vo.setEndPage(endPage);
		
		return vo;
	}
}

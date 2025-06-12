package com.sist.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.web.repository.*;
import com.sist.web.entity.*;
import com.sist.web.vo.*;
import com.sist.web.commons.*;
@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentRepository cDao;
	@Autowired
	private PageNation pn;
	@Override
	public Map commentListData(int type,int bno,int page) {
		Map map=new HashMap();
		
		int rowSize=10;
		int start=(page-1)*rowSize;
		List<CommentVO> list=cDao.commentListData(type,bno,start);
		int count=cDao.commentCount(type,bno);
		int totlapage=(int)(Math.ceil(count/(double)rowSize));
		PageVO pvo=pn.pageNation(page, totlapage);
		
		map.put("list", list);
		map.put("page", pvo);
		
		return map;
	}
	@Override
	public void commentInsert(CommentEntity vo) {
		int no=cDao.MaxNo();
		vo.setNo(no);
		vo.setRegdate(new Date());
		cDao.save(vo);
	}
	@Override
	public void commentDelete(int no) {
		CommentEntity vo=cDao.findByNo(no);
		cDao.delete(vo);
	}
	@Override
	public void commentUpdate(CommentEntity vo) {
		CommentEntity dvo=cDao.findByNo(vo.getNo());
		dvo.setMsg(vo.getMsg());
		cDao.save(dvo);
	}
	
}

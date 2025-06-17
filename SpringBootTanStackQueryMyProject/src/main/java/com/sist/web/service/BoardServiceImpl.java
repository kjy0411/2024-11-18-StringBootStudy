package com.sist.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import com.sist.web.commons.*;
import com.sist.web.repository.*;
import com.sist.web.entity.*;
import com.sist.web.vo.*;
@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardRepository bDao;
	@Autowired
	private CommentRepository cDao;
	@Autowired
	private PageNation pn;
	@Override
	public Map boardListData(int page) {
		Map map=new HashMap();
		int rowSize=10;
		int start=(page-1)*rowSize;
		List<BoardVO> list=bDao.boardListData(start);
		int count=(int)bDao.count();
		int totalpage=(int)(Math.ceil(count/(double)rowSize));
		PageVO vo=pn.pageNation(page, totalpage);
		
		String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		map.put("list", list);
		map.put("page", vo);
		map.put("today", today);
		return map;
	}
	@Override
	public Map boardDetailData(int no) {
		Map map=new HashMap();
		BoardEntity vo=bDao.findByNo(no);
		vo.setHit(vo.getHit()+1);
		bDao.save(vo);
		
		BoardVO dvo=bDao.boardDetailData(no);
		map.put("detail", dvo);
		return map;
	}
	@Override
	public void boardInsert(BoardEntity vo) {
		vo.setRegdate(new Date());
		bDao.save(vo);
	}
	@Override
	public void boardDelete(int no) {
		BoardEntity vo=bDao.findByNo(no);
		// 댓글 삭제
		List<CommentEntity> list=cDao.findByTypeAndBno(2, no);
		for(CommentEntity cvo:list) {
			cDao.delete(cvo);
		}
		
		bDao.delete(vo);
	}
	@Override
	public Map boardUpdateData(int no) {
		Map map=new HashMap();
		BoardVO dvo=bDao.boardDetailData(no);
		map.put("detail", dvo);
		return map;
	}
	@Override
	public void boardUpdate(BoardEntity vo) {
		BoardEntity evo=bDao.findByNo(vo.getNo());
		evo.setSubject(vo.getSubject());
		evo.setContent(vo.getContent());
		bDao.save(evo);
	}
}

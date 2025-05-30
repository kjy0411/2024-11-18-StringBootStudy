package com.sist.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.web.entity.*;
import com.sist.web.dao.*;
@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardRepository bDao;
	@Override
	public List<BoardEntity> boardListDate(int start) {
		return bDao.boardListDate(start);
	}

	@Override
	public BoardEntity findByNo(int no) {
		return bDao.findByNo(no);
	}

	@Override
	public int count() {
		return (int)bDao.count();
	}

	@Override
	public BoardEntity save(BoardEntity vo) {
		return bDao.save(vo);
	}

	@Override
	public void delete(BoardEntity vo) {
		bDao.delete(vo);
	}

}

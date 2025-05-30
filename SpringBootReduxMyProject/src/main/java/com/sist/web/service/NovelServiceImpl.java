package com.sist.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.web.entity.*;
import com.sist.web.dao.*;
@Service
public class NovelServiceImpl implements NovelService{
	@Autowired
	private NovelRepository nDao;

	@Override
	public List<NovelEntity> mainNovelData() {
		return nDao.mainNovelData();
	}

	@Override
	public List<NovelEntity> novelListData(int start) {
		return nDao.novelListData(start);
	}

	@Override
	public int novelTotalPage() {
		return nDao.novelTotalPage();
	}

	@Override
	public NovelEntity novelDetailAndHit(int no) {
		NovelEntity vo=nDao.findByNo(no);
		vo.setHit(vo.getHit()+1);
		nDao.save(vo);
		vo=nDao.findByNo(no);
		return vo;
	}

	@Override
	public List<NovelEntity> novelFindByFdGenre(String fd, String genre, int start) {
		return nDao.novelFindByFdGenre(fd, genre, start);
	}

	@Override
	public int novelFindTotalPage(String fd, String genre) {
		return nDao.novelFindTotalPage(fd, genre);
	}
}

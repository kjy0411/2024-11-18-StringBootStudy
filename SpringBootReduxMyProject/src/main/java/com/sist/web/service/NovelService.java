package com.sist.web.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.*;

public interface NovelService {
	public List<NovelEntity> mainNovelData();
	public List<NovelEntity> novelListData(int start);
	public int novelTotalPage();
	public NovelEntity novelDetailAndHit(int no);
	public List<NovelEntity> novelFindByFdGenre(String fd,String genre,int start);
	public int novelFindTotalPage(String fd,String genre);
	public List<NovelEntity> novelListBySerial(String serial,int start);
	public int novelTotalPageBySerial(String serial);
}

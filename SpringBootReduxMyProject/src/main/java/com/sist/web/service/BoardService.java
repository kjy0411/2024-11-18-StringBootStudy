package com.sist.web.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.sist.web.entity.*;

public interface BoardService {
	public List<BoardEntity> boardListDate(int start);
	public BoardEntity findByNo(int no);
	public int count();
	public BoardEntity save(BoardEntity vo);
	public void delete(BoardEntity vo);
}

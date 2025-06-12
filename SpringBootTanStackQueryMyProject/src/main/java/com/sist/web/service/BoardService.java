package com.sist.web.service;
import java.util.*;
import com.sist.web.repository.*;
import com.sist.web.entity.*;
import com.sist.web.vo.*;
public interface BoardService {
	public Map boardListData(int page);
	public Map boardDetailData(int no);
	public void boardInsert(BoardEntity vo);
	public void boardDelete(int no);
	public Map boardUpdateData(int no);
	public void boardUpdate(BoardEntity vo);
}

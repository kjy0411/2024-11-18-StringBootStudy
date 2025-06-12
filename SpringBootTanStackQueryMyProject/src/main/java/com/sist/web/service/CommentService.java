package com.sist.web.service;
import java.util.*;
import com.sist.web.entity.*;
import com.sist.web.vo.*;
public interface CommentService {
	public Map commentListData(int type,int bno,int page);
	public void commentInsert(CommentEntity vo);
	public void commentDelete(int no);
	public void commentUpdate(CommentEntity vo);
}

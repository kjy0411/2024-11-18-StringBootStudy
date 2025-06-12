package com.sist.web.service;
import java.util.*;
import com.sist.web.entity.*;
import com.sist.web.vo.*;
public interface CampService {
	public Map campListData(int page,int rows);
	public Map campDetailData(int cno,int hc);
	public Map campFindData(int page, int rows, String fd);
}

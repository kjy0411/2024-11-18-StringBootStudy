package com.sist.web.service;
import java.util.*;
import com.sist.web.repository.*;
import com.sist.web.entity.*;
import com.sist.web.vo.*;
public interface MainService {
	public int idCount(String id);
	public Map memberLogin(String id,String pwd);
	public List<CampListVO> mainCampData();
}

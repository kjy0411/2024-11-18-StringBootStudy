package com.sist.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.web.vo.*;
import com.sist.web.dao.*;
@Service
public class MusicService {
	@Autowired
	private MusicRepository mRepository;
	
	public void saveMusic(Music music) {
		mRepository.save(music);
	}
	public List<Music> getAllMusic(int page){
		// 페이지 나누기
		int rowSize=12;
		Pageable pg=PageRequest.of(page-1,rowSize);
		// 나눈 페이지 읽기
		Page<Music> pList=mRepository.findAll(pg);
		// 리스트로 변환
		List<Music> list=new ArrayList<Music>();
		if(pList!=null && pList.hasContent()) {
			list=pList.getContent();
		}
		return list;
	}
	public int getTotalPage() {
		int count=(int)mRepository.count();// SELECT COUNT(*) FROM music
		int totalpage=(int)(Math.ceil(count/12.0));
		return totalpage;
	}
	public Music getMusicId(String id) {
		return mRepository.findById(id).orElse(null);
	}
	public List<Music> getMusicFindData(String title){
		return mRepository.findByTitleContaining(title);
	}
}

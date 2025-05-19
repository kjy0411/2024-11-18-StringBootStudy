package com.sist.web.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.sist.web.vo.EBusanInfo;

public interface EBusanInfoRepository extends ElasticsearchRepository<EBusanInfo, Integer>{
	public EBusanInfo findById(int id);
}

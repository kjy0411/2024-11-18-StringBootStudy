package com.sist.web.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import com.sist.web.vo.*;
@Repository
public interface MemberRepository extends ElasticsearchRepository<Member, String>{

}

package com.sist.web.vo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Document(indexName = "member")
@Getter
@Setter
public class Member {
	@Id
	private String id;
	private String name;
	private Integer age;
}

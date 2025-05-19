package com.sist.web.vo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Getter;
import lombok.Setter;

@Document(indexName = "music")
@Getter
@Setter
public class Music {
	@Id
	private String id;
	private String title;
	private String singer;
	private String album;
	private String poster;
	private String state;
	private int idcrement;
}

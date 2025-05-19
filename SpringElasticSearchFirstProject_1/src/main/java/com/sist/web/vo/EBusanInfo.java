package com.sist.web.vo;
/*
id int 
CNO int 
TITLE text 
POSTER text 
ADDRESS text 
PHONE text 
INFO text
 */

import org.springframework.data.elasticsearch.annotations.Document;

import jakarta.persistence.Id;
import lombok.Data;

@Document(indexName = "busaninfo")
@Data
public class EBusanInfo {
	@Id
	private int id,cno;
	private String title,poster,address,phone,info;
}

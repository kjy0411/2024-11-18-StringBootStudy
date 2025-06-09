package com.sist.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.*;

import org.hibernate.annotations.DynamicUpdate;
/*
no int AI PK 
name text 
subject text 
content text 
pwd text 
regdate datetime 
hit int
 */
@Entity(name = "board")
@Data
@DynamicUpdate
public class BoardEntity {
	@Id
	private int no;
	private String name;
	private String subject;
	private String content;
	@Column(insertable = true,updatable = false)
	private String pwd;
	@Column(insertable = true,updatable = false)
	private Date regdate;
	private int hit;
}

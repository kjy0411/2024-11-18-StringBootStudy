package com.sist.web.entity;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/*
no int PK 
GENRE text 
TITLE text 
POSTER text 
AUTHOR text 
STORY text 
AVGSTAR double 
SERIAL text 
ISCP text
HIT int
 */
@Entity(name = "novel")
@Data
@DynamicUpdate
public class NovelEntity {
	@Id
	private int no;
	private int hit;
	private double avgstar;
	private String genre,title,poster,author,story,serial,iscp;
}

package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/*
NO           NOT NULL NUMBER         
POSTER       NOT NULL VARCHAR2(4000) 
TITLE        NOT NULL VARCHAR2(1000) 
CHEF         NOT NULL VARCHAR2(1000) 
CHEF_POSTER  NOT NULL VARCHAR2(1000) 
CHEF_PROFILE NOT NULL VARCHAR2(1000) 
INFO1        NOT NULL VARCHAR2(100)  
INFO2        NOT NULL VARCHAR2(100)  
INFO3        NOT NULL VARCHAR2(100)  
CONTENT      NOT NULL VARCHAR2(4000) 
FOODMAKE     NOT NULL CLOB           
DATA                  CLOB 
 */
@Entity(name = "recipedetail")
@Data
public class RecipeDetailEntity {
	@Id
	private int no;
	private String poster,title,chef,chef_poster,chef_profile,info1,info2,info3,content,foodmake,data;
}

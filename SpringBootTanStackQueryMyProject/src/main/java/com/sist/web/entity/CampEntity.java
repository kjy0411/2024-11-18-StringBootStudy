package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/*
cno int PK 
TITLE text 
INTRO text 
POSTER text 
MANAGESTTUS text 
HVOFBGNDE text 
HVOFENDDLE text 
OPERPDCL text 
INDUTY text 
LCTCL text 
ADDR text 
DONM text 
GNRLSITECO int 
AUTOSITECO int 
GLAMPSITECO int 
CARAVSITECO int 
INDVDLCARAVSITECO int 
CARAVACMPNYAT text 
TRLERACMPNYAT text 
ANIMALCMGCL text 
HIT int 
FCOUNT int 
LCOUNT int 
RCOUNT int 
MAPX double 
MAPY double 
PRICE int 
OPERDECL int
 */
@Entity(name = "camp")
@Data
public class CampEntity {
	@Id
	private int cno;
	private int gnrlsiteco,autositeco,glampsiteco,caravsiteco,indvdlcaravsiteco,hit,fcount,lcount,rcount,price,operdecl;
	private double mapx,mapy;
	private String title,intro,poster,managesttus,hvofbgnde,hvofenddle,operpdcl,induty,lctcl,addr,donm,caravacmpnyat,trleracmpnyat,animalcmgcl;
}

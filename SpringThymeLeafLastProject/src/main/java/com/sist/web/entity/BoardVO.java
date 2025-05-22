package com.sist.web.entity;
// SELECT * FROM ~~
// SELECT no,name,subject,regdate,hit
// 원하는 컬럼만 추출
public interface BoardVO {
	public int getNo();
	public String getName();
	public String getSubject();
	public String getRegdate();
	public int getHit();
}

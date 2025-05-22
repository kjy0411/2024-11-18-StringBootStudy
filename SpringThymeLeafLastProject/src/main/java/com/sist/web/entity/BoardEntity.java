package com.sist.web.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;

@Entity(name = "board")
@Data
@DynamicUpdate
// insert,update에서 입력하지 않은 항목 => null처리
public class BoardEntity {
	@Id
	private int no;
	private String name;
	private String subject;
	private String content;
	@Column(insertable = true,updatable = false)
	private String pwd;
	@Column(insertable = true,updatable = false)
	private String regdate;
	private int hit;
	// TO_CHAR X => 날짜를 문자열로 변경 => Entity
	@PrePersist
	public void regdate() {
		this.regdate=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
}
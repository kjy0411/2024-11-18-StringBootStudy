package com.sist.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.*;
@Entity(name = "board2")
@Data
public class BoardEntity {
	@Id
	private int no;
	@Column(insertable = true,updatable = false)
	private String id;
	@Column(insertable = true,updatable = false)
	private String name;
	private String subject;
	private String content;
	@Column(insertable = true,updatable = false)
	private Date regdate;
	private int hit;
}

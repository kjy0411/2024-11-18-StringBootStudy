package com.sist.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import java.util.*;
@Entity(name = "comment")
@Data
public class CommentEntity {
	@Id
	private int no;
	@Column(insertable = true,updatable = false)
	private int type;
	@Column(insertable = true,updatable = false)
	private int bno;
	@Column(insertable = true,updatable = false)
	private String id;
	@Column(insertable = true,updatable = false)
	private String name;
	private String msg;
	@Column(insertable = true,updatable = false)
	private Date regdate;
}

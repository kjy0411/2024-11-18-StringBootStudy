package com.sist.web.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Dept {
	@Id
	private int deptno;
	private String dname,loc;
}

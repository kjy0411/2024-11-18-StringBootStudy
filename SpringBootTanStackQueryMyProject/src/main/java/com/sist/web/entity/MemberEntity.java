package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "p_member")
@Data
public class MemberEntity {
	@Id
	private String id;
	private String pwd,name,sex;
}

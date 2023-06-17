package com.najagso.dto;

import java.sql.Timestamp;

public class MemberVO {
	// 필드
	private String name;
	private String id;
	private String pwd;
	private String email;
	private String phone;
	private Timestamp indate;
	
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Timestamp getIndate() {
		return indate;
	}
	
	@Override
	public String toString() {
		return "MemberVO [name=" + name + ", id=" + id + ", pwd=" + pwd + ", email=" + email + ", phone=" + phone
				+ ", indate=" + indate + "]";
	}
	
}

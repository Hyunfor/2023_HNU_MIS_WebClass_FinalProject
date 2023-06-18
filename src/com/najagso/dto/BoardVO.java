package com.najagso.dto;

import java.sql.Timestamp;

public class BoardVO {

	private int id;
	private Timestamp regDate;
	private Timestamp updateDate;
	private String code;
	private String name;
	private int delStatus;
	private Timestamp delDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	public Timestamp getDelDate() {
		return delDate;
	}
	public void setDelDate(Timestamp delDate) {
		this.delDate = delDate;
	}
	
	

}
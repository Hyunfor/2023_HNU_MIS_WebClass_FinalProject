package com.najagso.dto;

import java.sql.Timestamp;

public class ArticleVO {
	
	private int id;
	private String pass;
	private String name;
	private String title;
	private String content;
	private int readcount;
	private Timestamp writedate;
	private int board_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public Timestamp getWritedate() {
		return writedate;
	}
	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	
	@Override
	public String toString() {
		return "ArticleVO [id=" + id + ", pass=" + pass + ", name=" + name + ", title=" + title + ", content=" + content
				+ ", readcount=" + readcount + ", writedate=" + writedate + ", board_id=" + board_id + "]";
	}
	
}
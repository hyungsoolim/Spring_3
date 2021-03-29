package com.hs.s3.notice;

import java.sql.Date;

public class NoticeDTO {

	private long num;
	private String title;
	private String writer;
	private Date regDate;
	private long hit;
	private String contents;

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regdate) {
		this.regDate = regdate;
	}

	public long getHit() {
		return hit;
	}

	public void setHit(long hit) {
		this.hit = hit;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

}

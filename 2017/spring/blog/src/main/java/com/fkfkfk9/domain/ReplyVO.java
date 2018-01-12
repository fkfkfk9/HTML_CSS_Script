package com.fkfkfk9.domain;

import java.sql.Date;

public class ReplyVO {
/*
	rno         NUMBER               primary key,
    num         NUMBER               default 0  not null ,
    replytext   varchar2(1000)       not null,
    replyer     varchar2(50)         not null,
    regdate     DATE                 default sysdate NOT NULL,
    updatedate  DATE                 default sysdate NOT NULL    
*/
	private int rno;
	private int num;
	private String replytext;
	private String replyer;
	private Date regdate;
	private Date updatedate;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getReplytext() {
		return replytext;
	}
	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	@Override
	public String toString() {
		return "ReplyVO [rno=" + rno + ", num=" + num + ", replytext=" + replytext + ", replyer=" + replyer
				+ ", regdate=" + regdate + ", updatedate=" + updatedate + "]";
	}
	
	
}

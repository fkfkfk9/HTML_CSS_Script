package jsp_2017_12_01.mem.bean;

import java.sql.Timestamp;

public class Member {
	private int idx;
	private String userid;
	private String passwd;
	private String addr;
	private Timestamp reg_date;
	
	public Timestamp getReg_date() {return reg_date;}
	public void setReg_date(Timestamp reg_date) {this.reg_date = reg_date;}
	public int getIdx() {return idx;}
	public void setIdx(int idx) {this.idx = idx;}
	public String getUserid() {	return userid;}
	public void setUserid(String userid) {this.userid = userid;}
	public String getPasswd() {	return passwd;}
	public void setPasswd(String passwd) {this.passwd = passwd;}
	public String getAddr() {return addr;}
	public void setAddr(String addr) {this.addr = addr;}	
}

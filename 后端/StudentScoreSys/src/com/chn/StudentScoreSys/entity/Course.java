package com.chn.StudentScoreSys.entity;

public class Course {
	public int Cid;
	public String Cname;
	public int getCid() {
		return Cid;
	}
	public void setCid(int cid) {
		Cid = cid;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public Course(int cid, String cname) {
		super();
		Cid = cid;
		Cname = cname;
	}
	public Course() {
		super();
	}
	@Override
	public String toString() {
		return "Course [Cid=" + Cid + ", Cname=" + Cname + "]";
	}
	
	
}

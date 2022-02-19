package com.chn.StudentScoreSys.entity;

public class Student {
	private int Sid;
	private String Sname;
	private int Sclass;
	public int getSid() {
		return Sid;
	}
	public void setSid(int sid) {
		Sid = sid;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public int getSclass() {
		return Sclass;
	}
	public void setSclass(int sclass) {
		Sclass = sclass;
	}
	@Override
	public String toString() {
		return "Student [Sid=" + Sid + ", Sname=" + Sname + ", Sclass=" + Sclass + "]";
	}
	public Student(int sid, String sname, int sclass) {
		super();
		Sid = sid;
		Sname = sname;
		Sclass = sclass;
	}
	public Student() {
		super();
	}

}

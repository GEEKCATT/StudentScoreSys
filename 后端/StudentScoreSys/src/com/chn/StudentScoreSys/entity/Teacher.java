package com.chn.StudentScoreSys.entity;

public class Teacher {
	public int Tid;
	public String Tname;
	public int getTid() {
		return Tid;
	}
	public void setTid(int tid) {
		Tid = tid;
	}
	public String getTname() {
		return Tname;
	}
	public void setTname(String tname) {
		Tname = tname;
	}
	@Override
	public String toString() {
		return "Teather [Tid=" + Tid + ", Tname=" + Tname + "]";
	}
	public Teacher(int tid, String tname) {
		super();
		Tid = tid;
		Tname = tname;
	}
	public Teacher() {
		super();
	}
}

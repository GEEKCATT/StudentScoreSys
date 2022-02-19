package com.chn.StudentScoreSys.entity;

public class ABC {
	public String Sname;
	public String Cname;
	public String Tname;
	public int Score;

	public ABC(String sname, String cname, String tname, int score) {
		super();
		Sname = sname;
		Cname = cname;
		Tname = tname;
		Score = score;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public String getTname() {
		return Tname;
	}
	public void setTname(String tname) {
		Tname = tname;
	}
	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}
	@Override
	public String toString() {
		return "ABC [Sname=" + Sname + ", Cname=" + Cname + ", Tname=" + Tname + ", Score=" + Score + "]";
	}


	
}
package com.chn.StudentScoreSys.entity;

public class Score {
	public int Sid;
	public int Cid;
	public int Tid;
	public int Value;
	public int getSid() {
		return Sid;
	}
	public void setSid(int sid) {
		Sid = sid;
	}
	public int getCid() {
		return Cid;
	}
	public void setCid(int cid) {
		Cid = cid;
	}
	public int getTid() {
		return Tid;
	}
	public void setTid(int tid) {
		Tid = tid;
	}
	public int getValue() {
		return Value;
	}
	public void setValue(int value) {
		Value = value;
	}
	@Override
	public String toString() {
		return "Score [Sid=" + Sid + ", Cid=" + Cid + ", Tid=" + Tid + ", Value=" + Value + "]";
	}
	public Score(int sid, int cid, int tid, int value) {
		super();
		Sid = sid;
		Cid = cid;
		Tid = tid;
		Value = value;
	}
	public Score() {
		super();
	}

	
}

package com.chn.StudentScoreSys.service;

import java.util.ArrayList;

import com.chn.StudentScoreSys.dao.ScoreDao;
import com.chn.StudentScoreSys.dao.StudentDao;
import com.chn.StudentScoreSys.entity.Score;
import com.chn.StudentScoreSys.entity.Student;

public class StudentService {
	//服务层    业务逻辑  按照功能分类    调用dao层
	StudentDao studentdao = new StudentDao();
	ScoreDao scoredao = new ScoreDao();
	
	public Student getInforStudent(int Sid) {
		return studentdao.selectBySid(Sid);
	}
	public Score getInforScoreA(int Sid,int Cid) {
		//查询单科成绩
		return scoredao.selectBySidAndCid(Sid,Cid);
	}
	public ArrayList<Score> getInforScoreB(int Sid) {
		//查询全部科目成绩
		return scoredao.selectAllBySid(Sid);
	}

	public static void main(String[] args) {
		StudentService ss = new StudentService();
//		System.out.println(ss.getInforScoreA(1,2));
//		System.out.println(ss.getInforScoreB(1));
		System.out.println(ss.getInforStudent(2));
	}

}

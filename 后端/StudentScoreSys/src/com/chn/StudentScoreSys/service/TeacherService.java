package com.chn.StudentScoreSys.service;

import java.util.ArrayList;

import com.chn.StudentScoreSys.dao.ScoreDao;
import com.chn.StudentScoreSys.dao.StudentDao;
import com.chn.StudentScoreSys.dao.TeacherDao;
import com.chn.StudentScoreSys.entity.Score;
import com.chn.StudentScoreSys.entity.Student;
import com.chn.StudentScoreSys.entity.Teacher;
import com.chn.StudentScoreSys.service.StudentService;//学生能做的功能,老师应当也能做

public class TeacherService {
	//服务层    业务逻辑  按照功能分类    调用dao层
	TeacherDao teacherdao = new TeacherDao();
	StudentDao studentdao = new StudentDao();
	ScoreDao scoredao = new ScoreDao();
	//*************************************************************对teacher表的操作
	public boolean insertInforTeacher(int Tid,String Tname) {
		boolean ret=false;
		Teacher teacher= new Teacher(Tid,Tname);
		if (teacherdao.insertTeacher(teacher)>0) {
			ret=true;
		}
		return ret;
	}
	public boolean deleteInforTeacher(int Tid) {
		//删除信息,置空成绩表中老师信息,已设置外键
		boolean ret=false;
		if(teacherdao.selectByTid(Tid)!=null) {
			if(teacherdao.deleteByTid(Tid)>0) {
				ret=true;
			}
		}
		return ret;
	}
	public boolean modifyInforTeacher(int Tid,String Tname) {
		//修改信息
		boolean ret=false;
		Teacher teacher= new Teacher(Tid,Tname);
		if(teacherdao.selectByTid(Tid)!=null) {
			if (teacherdao.updateTeacher(teacher)>0) {
				ret=true;
			}
		}
		return ret;
	}
	public Teacher getInforTeacher(int Tid) {
		return teacherdao.selectByTid(Tid);
	}
	
	
	

	//*************************************************************对student表的操作
	public boolean insertInforStudent(int Sid,String Sname,int Sclass) {
		//增加学生信息
		boolean ret=false;
		Student student= new Student(Sid,Sname,Sclass);
		if (studentdao.insertStudent(student)>0) {
			ret=true;
		}
		return ret;
	}
	public boolean deleteInforStudent(int Sid) {
		//删除信息,级联删除成绩表中记录
		boolean ret=false;
		if(studentdao.selectBySid(Sid)!=null) {
			if(studentdao.deleteBySid(Sid)>0) {
				ret=true;
			}
		}
		return ret;
	}
	public boolean modifyInforStudent(int Sid,String Sname,int Sclass) {
		//修改学生信息
		boolean ret=false;
		Student student= new Student(Sid,Sname,Sclass);
		if(studentdao.selectBySid(Sid)!=null) {
			if (studentdao.updateStudent(student)>0) {
				ret=true;
			}
		}
		return ret;
	}
	
	//*************************************************************对s_score表的操作
	public boolean insertInforScore(int Sid,int Cid,int Tid,int Value) {
		//增加学生成绩
		boolean ret=false;
		if(scoredao.selectBySidAndCid(Sid, Cid)==null) 
		{
			if (scoredao.insertScore(Sid,Cid,Tid,Value)>0) {
				ret=true;
			}
		}
		else
		{
			System.out.println("数据库中已有该成绩,插入失败");
		}
		return ret;
	}
	public boolean deleteInforScore(int Sid,int Cid) {
		//删除学生成绩
		boolean ret=false;
		if(scoredao.selectBySidAndCid(Sid, Cid)!=null) {
			if(scoredao.deleteBySidAndCid(Sid, Cid)>0) {
				ret=true;
			}
		}
		else System.out.println("Can't find Score");
		return ret;
	}
	public boolean modifyInforScore(int Sid,int Cid,int Tid,int Value) {
		//修改学生成绩
		boolean ret=false;
		Score score= new Score(Sid, Cid, Tid, Value);
		if(scoredao.selectBySidAndCid(Sid, Cid)!=null) {
			if (scoredao.updateScore(score)>0) {
				ret=true;
			}
		}
		return ret;
	}
	//查询学生成绩 by Sid ----在StudentService中
	//查询学生成绩 by Cid ----查询当前课程下所有的学生成绩
	public ArrayList<Score> getScoreByCid(int Cid) {
		return scoredao.selectAllByCid(Cid);
	}
	//查询学生成绩 by Tid ----查询当前老师教导的所有学生成绩
	public ArrayList<Score> getScoreByTid(int Tid) {
		return scoredao.selectAllByTid(Tid);
	}
	
	
	
	
	
	//main   alt+/
	public static void main(String[] args) {
		TeacherService Ts = new TeacherService();
		int Sid=6;
		int Cid=5;
		int Tid=5;
		int Value=99;
		int Sclass=7;
		String Tname="王麻子";
		String Sname="小李子";
		
//		Ts.insertInforScore(Sid, Cid, Tid, Value);
//		Ts.deleteInforScore(Sid, Cid);
//		Ts.modifyInforTeacher(Tid, Tname);
//		System.out.println(Ts.getInforTeacher(Tid));
//		Ts.insertInforStudent(Sid, Sname, Sclass);
//		Ts.deleteInforStudent(Sid);
//		Ts.modifyInforStudent(Sid, "Lisa", 10);
//		Ts.insertInforScore(Sid, Cid, Tid, Value);
//		Ts.deleteInforScore(Sid, Cid);
//		Ts.modifyInforScore(Sid, Cid, 1, 66);
//		System.out.println(Ts.getScoreByCid(2));
//		System.out.println(Ts.getScoreByTid(1));
		
		
		System.out.println(Ts.getScoreByCid(1));
		
		
		
	}

}

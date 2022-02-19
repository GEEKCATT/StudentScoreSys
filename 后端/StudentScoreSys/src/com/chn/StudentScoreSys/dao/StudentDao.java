package com.chn.StudentScoreSys.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chn.StudentScoreSys.entity.Student;

public class StudentDao extends BaseDao {
	public Student selectBySid(int Sid) {
		Student student = null;
		String sql = "select * from student where Sid=?";
		try {
			//通过连接对象获得语句对象
			PreparedStatement pst = getConn().prepareStatement(sql);
			//执行之前补全sql语句
			pst.setInt(1, Sid);
			//执行sql语句   结果集
			ResultSet rs = pst.executeQuery();
			//判断结果集是否有值
			if(rs.next()){
				student = new Student(rs.getInt(1),rs.getString(2),rs.getInt(3));
			}
			//关闭资源
			rs.close();
			pst.close();
			closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}
	public ArrayList<Student> selectAllstudent() {
		Student student = null;
		ArrayList<Student> list= new ArrayList<Student>();
		String sql = "select * from student";
		try {
			//通过连接对象获得语句对象
			PreparedStatement pst = getConn().prepareStatement(sql);
			//执行sql语句   结果集
			ResultSet rs = pst.executeQuery();
			//判断结果集是否有值
			while(rs.next()){
				student = new Student(rs.getInt(1),rs.getString(2),rs.getInt(3));
				list.add(student);
			}
			//关闭资源
			rs.close();
			pst.close();
			closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public int updateStudent(Student student) {
		int num = 0;
		String sql = "update student set Sname=?,Sclass=? where Sid=?";//用null是因为数据表中选择了自增
		try {
			PreparedStatement pst = getConn().prepareStatement(sql);
			//执行之前补全sql语句
			pst.setString(1, student.getSname());
			pst.setInt(2, student.getSclass());
			pst.setInt(3, student.getSid());
			//执行sql语句
			num = pst.executeUpdate();
			System.out.println("修改了"+num+"条数据");
			//关闭资源
			pst.close();
			closeConn();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	public int insertStudent(Student student){
		int num = 0;
		String sql = "insert into student values(?,?,?)";//用null是因为数据表中选择了自增
		//通过连接对象获得语句对象
		try {
			PreparedStatement pst = getConn().prepareStatement(sql);
			//执行之前补全sql语句
			pst.setInt(1, student.getSid());
			pst.setString(2, student.getSname());
			pst.setInt(3, student.getSclass());
			//执行sql语句
			num = pst.executeUpdate();
			System.out.println("添加了"+num+"条数据");
			//关闭资源
			pst.close();
			closeConn();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	public int deleteBySid(int Sid){
		int num = 0;
		
		String sql = "delete from student where Sid=?";
		//通过连接对象获得语句对象
		try {
			PreparedStatement pst = getConn().prepareStatement(sql);
			//执行之前补全sql语句
			pst.setInt(1,Sid);
			//执行sql语句
			num = pst.executeUpdate();
			System.out.println("删除了"+num+"条数据");
			//关闭资源
			pst.close();
			closeConn();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	public static void main(String[] args) {
		StudentDao studentdao = new StudentDao();
		Student student = studentdao.selectBySid(1);
		System.out.println(student);
		System.out.println(studentdao.selectAllstudent().toString());

//		Student student2 = new Student(2,"阿先",2);
//		studentdao.insertStudent(student2);
//		
//		studentdao.deleteBySid(1002);
	}

}

package com.chn.StudentScoreSys.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chn.StudentScoreSys.entity.Course;

public class CourseDao extends BaseDao {
	public Course selectByCid(int Cid) {
		Course course = null;
		String sql = "select * from course where Cid=?";
		try {
			//通过连接对象获得语句对象
			PreparedStatement pst = getConn().prepareStatement(sql);
			//执行之前补全sql语句
			pst.setInt(1, Cid);
			//执行sql语句   结果集
			ResultSet rs = pst.executeQuery();
			//判断结果集是否有值
			if(rs.next()){
				course = new Course(rs.getInt(1),rs.getString(2));
			}
			//关闭资源
			rs.close();
			pst.close();
			closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return course;
	}
	public ArrayList<Course> selectAllcourse() {
		Course course = null;
		ArrayList<Course> list= new ArrayList<Course>();
		String sql = "select * from course";
		try {
			//通过连接对象获得语句对象
			PreparedStatement pst = getConn().prepareStatement(sql);
			//执行sql语句   结果集
			ResultSet rs = pst.executeQuery();
			//判断结果集是否有值
			while(rs.next()){
				course = new Course(rs.getInt(1),rs.getString(2));
				list.add(course);
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
	public int updateCourse(Course course) {
		int num = 0;
		String sql = "update course set Cname=?  where Cid=?";//用null是因为数据表中选择了自增
		try {
			PreparedStatement pst = getConn().prepareStatement(sql);
			//执行之前补全sql语句
			pst.setString(1, course.getCname());
			pst.setInt(2, course.getCid());
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
	public int insertCourse(Course course){
		int num = 0;
		String sql = "insert into course values(?,?)";//用null是因为数据表中选择了自增
		//通过连接对象获得语句对象
		try {
			PreparedStatement pst = getConn().prepareStatement(sql);
			//执行之前补全sql语句
			pst.setInt(1, course.getCid());
			pst.setString(2, course.getCname());
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
	public int deleteByCid(int Cid){
		int num = 0;
		
		String sql = "delete from course where Cid=?";
		//通过连接对象获得语句对象
		try {
			PreparedStatement pst = getConn().prepareStatement(sql);
			//执行之前补全sql语句
			pst.setInt(1,Cid);
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
		CourseDao couresdao = new CourseDao();
		System.out.println(couresdao.selectByCid(5003));
		System.out.println(couresdao.selectAllcourse().toString());

//		Course coures2 = new Course(2,"操作系统");
//		couresdao.insertCourse(coures2);
		
//		couresdao.deleteByCid(5002);
//		System.out.println(couresdao.getCnameByCid(5002));
	}
	
}

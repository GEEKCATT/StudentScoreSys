package com.chn.StudentScoreSys.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chn.StudentScoreSys.entity.Teacher;

public class TeacherDao extends BaseDao {
	public Teacher selectByTid(int Tid) {
		Teacher teacher = null;
		String sql = "select * from teacher where Tid=?";
		try {
			//通过连接对象获得语句对象
			PreparedStatement pst = getConn().prepareStatement(sql);
			//执行之前补全sql语句
			pst.setInt(1, Tid);
			//执行sql语句   结果集
			ResultSet rs = pst.executeQuery();
			//判断结果集是否有值
			if(rs.next()){
				teacher = new Teacher(rs.getInt(1),rs.getString(2));
			}
			//关闭资源
			rs.close();
			pst.close();
			closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teacher;
	}
	public ArrayList<Teacher> selectAllteacher() {
		Teacher teacher = null;
		ArrayList<Teacher> list= new ArrayList<Teacher>();
		String sql = "select * from teacher";
		try {
			//通过连接对象获得语句对象
			PreparedStatement pst = getConn().prepareStatement(sql);
			//执行sql语句   结果集
			ResultSet rs = pst.executeQuery();
			//判断结果集是否有值
			while(rs.next()){
				teacher = new Teacher(rs.getInt(1),rs.getString(2));
				list.add(teacher);
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
	public int updateTeacher(Teacher teacher) {
		int num = 0;
		String sql = "update teacher set Tname=?  where Tid=?";//用null是因为数据表中选择了自增
		try {
			PreparedStatement pst = getConn().prepareStatement(sql);
			//执行之前补全sql语句
			pst.setString(1, teacher.getTname());
			pst.setInt(2, teacher.getTid());
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
	public int insertTeacher(Teacher teacher){
		int num = 0;
		String sql = "insert into teacher values(?,?)";//用null是因为数据表中选择了自增
		//通过连接对象获得语句对象
		try {
			PreparedStatement pst = getConn().prepareStatement(sql);
			//执行之前补全sql语句
			pst.setInt(1, teacher.getTid());
			pst.setString(2, teacher.getTname());
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
	public int deleteByTid(int Tid){
		int num = 0;
		
		String sql = "delete from teacher where Tid=?";
		//通过连接对象获得语句对象
		try {
			PreparedStatement pst = getConn().prepareStatement(sql);
			//执行之前补全sql语句
			pst.setInt(1,Tid);
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
		TeacherDao teacherdao = new TeacherDao();
//		Teacher teacher = teacherdao.selectByTid(2002);
//		System.out.println(teacher);
//
//		Teacher teacher2 = new Teacher(2,"阿先");
//		teacherdao.insertTeacher(teacher2);

		System.out.println(teacherdao.selectAllteacher().toString());
//		teacherdao.deleteByTid(2002);
	}

}
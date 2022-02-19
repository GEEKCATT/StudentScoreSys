package com.chn.StudentScoreSys.dao;
//dao层 	//增//删//改//查 byId//查询全部
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chn.StudentScoreSys.entity.User;

/**
 * @author Administrator
 *
 */
public class UserDao extends BaseDao{
	//增//删//改//查 byId//查询全部
	
	//登录 
	//查询 byUsername
	// ctrl+shift+o
	public ArrayList<User> selectAllUser(){
		ArrayList<User> userlist= new ArrayList<User>();
		String sql = "select * from user";
		try {
			//通过连接对象获得语句对象
			PreparedStatement pst = getConn().prepareStatement(sql);
			//执行之前补全sql语句
			//执行sql语句   结果集
			ResultSet rs = pst.executeQuery();
			//判断结果集是否有值
			while(rs.next()){
				userlist.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
			//关闭资源
			rs.close();
			pst.close();
			closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userlist;
	}
	public User selectByUsername(String username){
		User user = null;
		String sql = "select * from user where username=?";
		try {
			//通过连接对象获得语句对象
			PreparedStatement pst = getConn().prepareStatement(sql);
			//执行之前补全sql语句
			pst.setString(1, username);
			//执行sql语句   结果集
			ResultSet rs = pst.executeQuery();
			//判断结果集是否有值
			if(rs.next()){
				user = new User(rs.getInt(1),rs.getString(2),rs.getString(3));
			}
			//关闭资源
			rs.close();
			pst.close();
			closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	
	public int insertUser(User user){
		int num = 0;
		String sql = "insert into user values(null,?,?)";//用null是因为数据表中userid选择了自增
		//通过连接对象获得语句对象
		try {
			PreparedStatement pst = getConn().prepareStatement(sql);
			//执行之前补全sql语句
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
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
	
	
	//注册
	//增加
	//main   alt+/
	public static void main(String[] args) {
		UserDao userdao = new UserDao();
		User user = userdao.selectByUsername("admin");
		System.out.println(user);
		
		User user2 = new User(1,"lisi","123");
		userdao.insertUser(user2);
	}
}

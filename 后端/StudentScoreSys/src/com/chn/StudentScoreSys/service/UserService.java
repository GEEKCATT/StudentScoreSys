
package com.chn.StudentScoreSys.service;
//服务层    业务逻辑 
import com.chn.StudentScoreSys.dao.UserDao;
import com.chn.StudentScoreSys.entity.User;

/**
 * @author Administrator
 *
 */
public class UserService {
	//服务层    业务逻辑  按照功能分类    调用dao层
	UserDao userdao = new UserDao();
	
	public User login(String username,String password){
		//假设登录失败
		//boolean success = false;
		//通过用户填写的用户名查找用户
		User user = userdao.selectByUsername(username);
		//如果找到了，判断密码是否正确
		if(user!=null && user.getPassword().equals(password)){
			//正确返回 true  登录成功
			return user;
		}
		return null;
	}
	
	//注册功能
	public boolean regist(User user){
		boolean success = false;
		//判断是否存在用户  如果已经存在  不能注册
		User user2 = userdao.selectByUsername(user.getUsername());
		if(user2==null){
			//没有此用户  可以注册
			int num = userdao.insertUser(user);
			if(num>0){
				success = true;
			}
		}
		return success;
	}
	
	//main   alt+/
	public static void main(String[] args) {
		UserService us = new UserService();
		//boolean flag = us.login("admin", "admin");
		//System.out.println(flag);
		
		System.out.println("-------注册功能-------");
		User user = new User(2,"oppoo","123");
		boolean flag2 = us.regist(user);
		System.out.println(flag2);
	}
	
}

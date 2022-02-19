package com.chn.StudentScoreSys.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chn.StudentScoreSys.entity.User;
import com.chn.StudentScoreSys.service.UserService;
import com.google.gson.Gson;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//接收用户传递的值   username   password
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				System.out.println("用户名:"+username+";密码:"+password);
				//调用service
				UserService us = new UserService();
				User u = new User(1,username,password);
				boolean success = us.regist(u);
				
				PrintWriter out = response.getWriter();
				Gson gson = new Gson();
				
				if(success){
					//通过io流 输出对应的数据，利用gson工具  将数据转化为json格式
					Map<String, Object> result = new HashMap<String,Object>();
					result.put("errorcode", 0);
					result.put("status", "注册成功");
					Map<String, Object> map = new HashMap<String,Object>();
					map.put("result", result);
					//将map类型转为json类型传递给前端
					out.println(gson.toJson(map));
				}else{
					//通过io流 输出对应的数据，利用gson工具  将数据转化为json格式
					Map<String, Object> result = new HashMap<String,Object>();
					result.put("errorcode", 200);
					result.put("status", "注册失败");
					Map<String, Object> map = new HashMap<String,Object>();
					map.put("result", result);
					//将map类型转为json类型传递给前端
					out.println(gson.toJson(map));
				}
				out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

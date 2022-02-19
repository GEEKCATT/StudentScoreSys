package com.chn.StudentScoreSys.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chn.StudentScoreSys.dao.StudentDao;
import com.chn.StudentScoreSys.entity.Student;
import com.google.gson.Gson;

/**
 * Servlet implementation class SelectAllStudent
 */
@WebServlet("/SelectAllStudent")
public class SelectAllStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDao studentdao = new StudentDao();
		ArrayList<Student> list = studentdao.selectAllstudent();

		PrintWriter out = response.getWriter();
		Gson gson = new Gson();

		Map<String, Object> result = new HashMap<String,Object>();
		result.put("errorcode", 0);
		result.put("status", "查询成功");
		result.put("list", list);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("result", result);
		//将map类型转为json类型传递给前端
		out.println(gson.toJson(map));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

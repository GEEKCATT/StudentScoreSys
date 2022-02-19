package com.chn.StudentScoreSys.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chn.StudentScoreSys.service.TeacherService;

/**
 * Servlet implementation class insertInforStudent
 */
@WebServlet("/insertInforStudent")
public class insertInforStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertInforStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int Sid = new Integer(request.getParameter("Sid"));
		String Sname = request.getParameter("Sname");
		int Sclass = new Integer(request.getParameter("Sclass"));
				
		System.out.println("Sid:"+Sid+"  Sname:"+Sname+"  Sclass:"+Sclass);
		//调用service
		TeacherService ss = new TeacherService();
		boolean out=ss.insertInforStudent(Sid, Sname, Sclass);	
		String ret=out? "添加学生信息成功":"添加学生信息失败";
		
		response.getWriter().append(ret);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

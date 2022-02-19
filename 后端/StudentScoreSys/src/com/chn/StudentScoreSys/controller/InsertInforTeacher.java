package com.chn.StudentScoreSys.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chn.StudentScoreSys.service.TeacherService;

/**
 * Servlet implementation class InsertInforTeacher
 */
@WebServlet("/InsertInforTeacher")
public class InsertInforTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertInforTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int Tid = new Integer(request.getParameter("Tid"));
		String Tname = request.getParameter("Tname");
				
		System.out.println("Tid:"+Tid+"  Tname:"+Tname);
		//调用service
		TeacherService ss = new TeacherService();
		boolean out=ss.insertInforTeacher(Tid,Tname);	
		String ret=out? "添加教师信息成功":"添加教师信息失败";
		
		response.getWriter().append(request.getContextPath()).append(ret);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

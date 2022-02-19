package com.chn.StudentScoreSys.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chn.StudentScoreSys.service.TeacherService;

/**
 * Servlet implementation class deleteInforTeacher
 */
@WebServlet("/deleteInforTeacher")
public class deleteInforTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteInforTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int Tid = new Integer(request.getParameter("Tid"));
				
		System.out.println("Tid:"+Tid);
		//调用service
		TeacherService ss = new TeacherService();
		boolean out=ss.deleteInforTeacher(Tid);	
		String ret=out? "删除教师信息成功":"删除教师信息失败";
		
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

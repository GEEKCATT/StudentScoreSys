package com.chn.StudentScoreSys.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chn.StudentScoreSys.entity.Teacher;
import com.chn.StudentScoreSys.service.TeacherService;

/**
 * Servlet implementation class getInforTeacher
 */
@WebServlet("/getInforTeacher")
public class getInforTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getInforTeacher() {
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
		//µ÷ÓÃservice
		TeacherService ss = new TeacherService();
		Teacher out=ss.getInforTeacher(Tid);	
		
		response.getWriter().append(out.toString());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

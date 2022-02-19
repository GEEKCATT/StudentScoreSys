package com.chn.StudentScoreSys.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chn.StudentScoreSys.entity.Student;
import com.chn.StudentScoreSys.service.StudentService;

/**
 * Servlet implementation class GetInforStudent
 */
@WebServlet("/GetInforStudent")
public class GetInforStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetInforStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int Sid = new Integer(request.getParameter("Sid"));
		System.out.println("Sid:"+Sid);
		//µ÷ÓÃservice
		StudentService ss = new StudentService();
		Student out=ss.getInforStudent(Sid);	
		
		response.getWriter().append("Served at: ").append(request.getContextPath()).append(out.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

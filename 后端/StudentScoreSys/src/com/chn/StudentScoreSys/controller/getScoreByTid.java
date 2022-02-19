package com.chn.StudentScoreSys.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chn.StudentScoreSys.entity.Score;
import com.chn.StudentScoreSys.service.TeacherService;

/**
 * Servlet implementation class getScoreByTid
 */
@WebServlet("/getScoreByTid")
public class getScoreByTid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getScoreByTid() {
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
		ArrayList<Score> out=ss.getScoreByTid(Tid);	
		
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

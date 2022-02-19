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
 * Servlet implementation class getScoreByCid
 */
@WebServlet("/getScoreByCid")
public class getScoreByCid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getScoreByCid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int Cid = new Integer(request.getParameter("Cid"));
		System.out.println("Cid:"+Cid);
		//µ÷ÓÃservice
		TeacherService ss = new TeacherService();
		ArrayList<Score> out=ss.getScoreByCid(Cid);	
		
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

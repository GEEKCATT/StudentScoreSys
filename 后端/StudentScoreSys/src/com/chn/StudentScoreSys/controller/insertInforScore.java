package com.chn.StudentScoreSys.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chn.StudentScoreSys.service.TeacherService;

/**
 * Servlet implementation class insertInforScore
 */
@WebServlet("/insertInforScore")
public class insertInforScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertInforScore() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int Sid = new Integer(request.getParameter("Sid"));
		int Cid = new Integer(request.getParameter("Cid"));
		int Tid = new Integer(request.getParameter("Tid"));
		int Value = new Integer(request.getParameter("Value"));
		//调用service
		TeacherService ss = new TeacherService();
		boolean out=ss.insertInforScore(Sid, Cid, Tid, Value);
		String ret=out? "添加学生成绩成功":"添加学生成绩失败";
		
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

package com.techpalle.model;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.Student;
import com.techpalle.dao.DAO;

/**
 * Servlet implementation class MyServlet1
 */
@WebServlet("/MyServlet1")
public class MyServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String mail=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		DAO d=new DAO();
		Student s=new Student(mail,pwd);
		ArrayList<Student> s1=new ArrayList<Student>();
		s1=d.read();
		for(int i=0;i<s1.size();i++) {
			if(mail.equals(s1.get(i).getEmail())&& pwd.equals(s1.get(i).getPwd())) {
				response.sendRedirect("success.jsp");
			}
			else {
				response.sendRedirect("invalid.jsp");
			}
		}
		
	}

}

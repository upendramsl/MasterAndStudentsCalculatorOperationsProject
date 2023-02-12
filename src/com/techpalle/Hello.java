package com.techpalle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String mname=request.getParameter("userName");

		String memail=request.getParameter("userEmail");

		String mdept=request.getParameter("department");

		String mpassword=request.getParameter("Password");
		
		
		
		String sname=request.getParameter("stuserName");

		String semail=request.getParameter("stuserEmail");

		String sdept=request.getParameter("stdepartment");

		String spassword=request.getParameter("stPassword");
		
		
		
	
		DataAccessObject d=new DataAccessObject();
		
		if(sname!=null)
		{
		Student s=new Student(sname, semail, sdept, spassword);
		d.StudentInserting(s);
		response.sendRedirect("StudentRegistration1.html");
		
		}
		
		else if(mname!=null)
		{
			Master m=new Master(mname, memail, mdept, mpassword);
			d.masterInserting(m);
			response.sendRedirect("MasterRegistration1.html");
		}
		
	}

}

package com.techpalle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter pw=response.getWriter();
		String memail=request.getParameter("mtbemail");
		String mpass=request.getParameter("mnpass");
		
		String semail=request.getParameter("stbemail");
		String spass=request.getParameter("snpass");
		
		DataAccessObject d=new DataAccessObject();
		if(memail!=null)
		{
		d.masterPasswordUpdating(mpass, memail);
		pw.append("<h1>Sucessfully Updates</h1>");
		}
		else if(semail!=null)
		{
			d.studentPasswordUpdating(spass, semail);
			pw.append("<h1>Sucessfully Updates</h1>");
		}
		
	}

}

package com.techpalle;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Hello1")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String lmemail=request.getParameter("userEmail");
		String lmpassword=request.getParameter("userpass");
		
		String lsemail=request.getParameter("suserEmail");
		String lspassword=request.getParameter("suserpass");
		
		
	    DataAccessObject d=new DataAccessObject();
	    
	    
	    if(lmemail!=null)
		{
		 ArrayList<LoginClass> h1=d.masterReading();
		 for(LoginClass l:h1)
		 {
			if(l.getEm().equals(lmemail)&&l.getPass().equals(lmpassword))
			{
				RequestDispatcher rd=request.getRequestDispatcher("MasterHome.jsp");
				rd.forward(request, response);
			}
			 else
			 {
				 response.sendRedirect("ErrorPage.html"); 
				 break;
				 
			 }
		 }}
		 else if(lsemail!=null)
			{
			 ArrayList<LoginClass> h1=d.studentReading();
			 for(LoginClass l:h1)
			 {
				if(l.getEm().equals(lsemail)&&l.getPass().equals(lspassword))
				{
					RequestDispatcher rd=request.getRequestDispatcher("StudentHome.jsp");
					rd.forward(request, response);
					
				}
				else
				 {
					 response.sendRedirect("ErrorPage.html"); 
					 break;
					 
				 }
			 }
	            
		  } 
		
	    
		
	}

}

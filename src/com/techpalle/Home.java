package com.techpalle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		DataAccessObject d=new DataAccessObject();
		
		String name=request.getParameter("user");
		String op=request.getParameter("operation");
		String fn=request.getParameter("firstnumber");
		String sn=request.getParameter("secondnumber");
		
     if(name!=null)
     {
	    d.updating(fn,sn,name,op);
	    out.append("<h1>Successfully Done</h1>");
     }  
		String em = request.getParameter("email"); 
	    
	  
	    ArrayList<LoginClass> h1=d.studentReading();
		for(LoginClass l:h1)
		{
		if(l.getEm().equals(em))
			{
		try { 
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "upendra"); 
			PreparedStatement ps = con.prepareStatement("select * from studentregistrations where email=?"); 
			ps.setString(1,em);
			
			ResultSet rs = ps.executeQuery(); 
				while (rs.next()) 
				{ 
				out.append("<h1>Previous Problem Remarks</h1>");
				out.println("<h2>"+rs.getString("operation")+"</h2>"); 
				out.println("<h2>"+rs.getInt("fisrt")+"</h2>");
				out.println("<h2>"+rs.getInt("second")+"</h2>");
				out.print("<h2>"+rs.getString("remarks")+"</h2>");
			} 
				
			
			ps.close();
			con.close();
		} catch (Exception e) { 
			e.printStackTrace(); 
	    
		}	
		
}
}}}

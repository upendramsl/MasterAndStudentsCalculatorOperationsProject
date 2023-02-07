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
		int no=request.getIntHeader("number");
		String name=request.getParameter("user");
		String op=request.getParameter("operation");
		String fn=request.getParameter("firstnumber");
		String sn=request.getParameter("secondnumber");
		

	    d.updating(fn,sn,name,op);
		String ID = request.getParameter("id"); 
	    String na=request.getParameter("name");
	  
	    ArrayList<LoginClass> h1=d.studentReading();
		for(LoginClass l:h1)
		{
		if(l.getEm().equals(na))
			{
		try { 
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "upendra"); 
			PreparedStatement ps = con.prepareStatement("select * from studentregistrations where sid=?"); 
			ps.setInt(1, Integer.parseInt(ID)); 
			
 
			ResultSet rs = ps.executeQuery(); 
				while (rs.next()) { 
				out.println("<h1>"+rs.getString("operation")+"</h1>"); 
				out.println("<h1>"+rs.getInt("fisrt")+"</h1>");
				out.println("<h1>"+rs.getInt("second")+"</h1>");
				out.print("<h1>"+rs.getString("remarks")+"</h1>");
			} 
				out.append("<form action=\"MHome\" method=\"post\">\r\n"
						+ "Enter your name:\r\n"
						+ "<input type=\"text\" name=\"username\"/>\r\n"
						+ "</br>\r\n"
						+ "Enter Your Answer:\r\n"
						+ "<input type=\"text\" name=\"usertext\">\r\n"
						+ "<input type=\"submit\" value=\"Submit\">\r\n"
						+ " </form>");
	   
			
			
			ps.close();
			con.close();
		} catch (Exception e) { 
			e.printStackTrace(); 
	    
		}	
}
}}}

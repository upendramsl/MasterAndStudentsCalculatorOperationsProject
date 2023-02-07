package com.techpalle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MHome
 */
@WebServlet("/MHome")
public class MHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

	    String name= request.getParameter("username"); 
	    String sum=request.getParameter("usertext");
	    DataAccessObject d=new DataAccessObject();
	   
		  
		d.resultUpdating(sum,name);
	    
	    String sid=request.getParameter("usno");
	    
	    PrintWriter out=response.getWriter();
	   
		try { 
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "upendra"); 
			PreparedStatement ps = con.prepareStatement("select * from studentregistrations where sid=?"); 
			ps.setInt(1, Integer.parseInt(sid)); 
 
			ResultSet rs = ps.executeQuery(); 
				while (rs.next()) { 
					out.println("<h1>"+rs.getInt("sid")+"</h1>"); 
					out.print("</br>");
					out.println("<h1>"+rs.getString("name")+"</h1>");
					out.append("</br>");
					out.println("<h1>"+rs.getString("email")+"</h1>");
					out.print("</br>");
				out.println("<h1>"+rs.getString("result")+"</h1>"); 
				
			} 
				out.append("<form action=\"SHome\" method=\"post\">\r\n"
						+ "Enter student no:\r\n"
						+ "<input type=\"text\" name=\"susername\"/>\r\n"
						+ "</br>\r\n"
						+ "Enter remarks:\r\n"
						+ "<input type=\"text\" name=\"susertext\">\r\n"
						+ "<input type=\"submit\" value=\"Submit\">\r\n"
						+ " </form>");
				
	
			ps.close();
			con.close();
		} catch (Exception e) { 
			e.printStackTrace(); 
	    
	
}
	}}



<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
  
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>  
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page import="com.techpalle.DataAccessObject" %>
<%@ page import="com.techpalle.LoginClass" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Home Page</title>
</head>
<body>

<%
DataAccessObject d=new DataAccessObject();
String em = request.getParameter("suserEmail");
String pa = request.getParameter("suserpass");

ArrayList<LoginClass> h1 = d.studentReading();
for (LoginClass l : h1) {
    if (l.getEm().equals(em) && l.getPass().equals(pa)) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "upendra");
            PreparedStatement ps = con.prepareStatement("select * from studentregistrations where email=? and Password=?");
            ps.setString(1, em);
            ps.setString(2, pa);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                out.println("<h1>" + rs.getString("operation") + "</h1>");
                out.println("<h1>" + rs.getInt("fisrt") + "</h1>");
                out.println("<h1>" + rs.getInt("second") + "</h1>");
                
            }

            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.append("<form action=\"MHome\" method=\"post\">\r\n" +
                "Enter your name:\r\n" +
                "<input type=\"text\" name=\"username\"/>\r\n" +
                "</br>\r\n" +
                "Enter Your Answer:\r\n" +
                "<input type=\"text\" name=\"usertext\">\r\n" +
                "<input type=\"submit\" value=\"Submit\">\r\n" +
                " </form>");
    }
}
%>
</br>
<h2>Please click her for Previous Activity</h2>
<a href="Review.html">clickher</a>
</body>
</html>
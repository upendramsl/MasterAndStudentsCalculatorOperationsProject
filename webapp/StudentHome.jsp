
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.techpalle.StudentHome"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Home</title>
</head>
<body>
<h1>welcome to Studenthome page</h1>
<h2>For Seeing your Work Please enter your number and click show </h2>
<form action="Home" method="post">
<table>
<tr>
<td>Enter your Id:</td>
<td>
<input type="text" name="id"></td>
</tr>
</br>
<tr>
<td>Enter your Email:
</td>
<td>
<input type="email" name="name"></td>
</tr>
</br>

<tr>
<td>
<input type="submit" value="show"/></td>
</tr>
</table>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MasterHome</title>
</head>
<body>
<h1>Master Home Page</h1>
<form action="Home" method="post">
<table>
<tr>
<td>
Please select Student id:
</td>
<td>
<select id="ddlStudentNumber" name="number">
<option>....select....</option>
<option>1</option>
<option>2</option>
<option>3</option>
<option>4</option>
<option>5</option>
</select>
</td>
</tr>
</br>
<tr>
<td>
Enter name:</td>
<td>
<input type="text" name="user"></td>
<br>
</tr>
<tr>
<td>
please select operation</td>
<td>
<select id="Calculator" name="operation">
<option>....select.....</option>
<option>Adding</option>
<option>Substraction</option>
<option>Multiplication</option>
<option>Division</option>
</select>
</td>
</tr>
</br>
<tr>
<td>enter the first number:</td>
<td>
<input type="number" name="firstnumber"></td>
</br>
</tr>
<tr>
<td>
enter the second number:</td>
<td><input type="number" name="secondnumber"></td>
</br>
</tr>
<tr>
<td>
<input type="submit" value="submit"></td>
</tr>
</table>
</form>
<h2>Please click below link To see StudentActivity</h2>
</br>
<a href="Masterstudents.html">Clickher</a>
</body>
</html>
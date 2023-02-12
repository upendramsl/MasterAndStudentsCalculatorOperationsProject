package com.techpalle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataAccessObject
{
	ArrayList<LoginClass> hm=new ArrayList<>();
	
	
	public  void masterInserting(Master m)
	{
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","upendra");
		String qry="insert into masterregistrations(name,email,department,password) values(?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(qry);
		
		ps.setString(1,m.getName());
		ps.setString(2,m.getEmail());
		ps.setString(3,m.getDept());
		ps.setString(4,m.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		con.close();
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
}
public void StudentInserting(Student s)
{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","upendra");
			String qry="insert into studentregistrations(name,email,Department,password) values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(qry);
			
			ps.setString(1,s.getName());
			ps.setString(2,s.getEmail());
			ps.setString(3,s.getDept());
			ps.setString(4,s.getPassword());
			
			ps.executeUpdate();
			
			
			ps.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
public ArrayList<LoginClass> masterReading()
{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","upendra");
		String qry="select * from masterregistrations";
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(qry);
		while(rs.next())
		{
			String email=rs.getString("email");
			String pass=rs.getString("Password");
			LoginClass l=new LoginClass(email, pass);
	        hm.add(l);
		}
		
		s.close();
		con.close();
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return hm;
	
	
}
public ArrayList<LoginClass> studentReading()
{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","upendra");
		String qry="select * from studentregistrations";
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(qry);
		while(rs.next())
		{
			String email=rs.getString("email");
			String pass=rs.getString("Password");
			LoginClass l=new LoginClass(email, pass);
	        hm.add(l);
		}
		
		s.close();
		con.close();
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return hm;
	
}
public void resultUpdating(String sum,String name)
{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","upendra");
		String qry="update studentregistrations set result=? where name=?";
		PreparedStatement ps=con.prepareStatement(qry);
		
		ps.setString(1,sum);
		ps.setString(2,name);
		ps.executeUpdate();
		ps.close();
		con.close();
		
	} catch (ClassNotFoundException e) {

		e.printStackTrace();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
}
public void updating(String fn,String sn,String n,String op)
{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","upendra");
		String qry="update studentregistrations set fisrt=?,second=?,operation=?  where name=?";
		PreparedStatement ps=con.prepareStatement(qry);
		
		ps.setString(1,fn);
		ps.setString(2,sn);
		ps.setString(3,op);
		ps.setString(4,n);
		ps.executeUpdate();
		ps.close();
		con.close();
		
	} catch (ClassNotFoundException e) {

		e.printStackTrace();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
}
public void remarksUpdating(String rema,String sid)
{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","upendra");
		String qry="update studentregistrations set remarks=? where sid=?";
		PreparedStatement ps=con.prepareStatement(qry);
		
		ps.setString(1,rema);
		ps.setInt(2,Integer.parseInt(sid));
		ps.executeUpdate();
		ps.close();
		con.close();
		
	} catch (ClassNotFoundException e) {

		e.printStackTrace();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
}
public void studentPasswordUpdating(String pass,String email)
{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","upendra");
		String qry="update studentregistrations set Password=? where email=?";
		PreparedStatement ps=con.prepareStatement(qry);
		
		ps.setString(1,pass);
		ps.setString(2,email);
		ps.executeUpdate();
		ps.close();
		con.close();
		
	} catch (ClassNotFoundException e) {

		e.printStackTrace();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
}
public void masterPasswordUpdating(String pass,String email)
{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","upendra");
		String qry="update masterregistrations set Password=? where email=?";
		PreparedStatement ps=con.prepareStatement(qry);
		
		ps.setString(1,pass);
		ps.setString(2,email);
		ps.executeUpdate();
		ps.close();
		con.close();
		
	} catch (ClassNotFoundException e) {

		e.printStackTrace();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
}
}
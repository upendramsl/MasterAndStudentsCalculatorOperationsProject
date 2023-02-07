package com.techpalle;

public class Master
{
	private String name;
	private String email;
	private String dept;
	private String password;
	
	public Master(String name, String email, String dept, String password)
	{
		super();
		this.name = name;
		this.email = email;
		this.dept = dept;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
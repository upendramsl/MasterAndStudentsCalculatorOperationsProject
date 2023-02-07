package com.techpalle;


public class StudentHome 
 {
	private int i;
	private String n;
	private String op;
	private int fs;
	private int ss;
	
	
	public StudentHome(int i, String n, String op, int fs, int ss) {
		super();
		this.i = i;
		this.n = n;
		this.op = op;
		this.fs = fs;
		this.ss = ss;
	}
	
	public int getI() {
		return i;
	}
   public void setI(int i) {
		this.i = i;
	}
	public String getN() {
		return n;
	}
	public void setN(String n) {
		this.n = n;
	}
   public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
   public int getFs() {
		return fs;
	}
	public void setFs(int fs) {
		this.fs = fs;
	}
	public int getSs() {
		return ss;
	}
	public void setSs(int ss) {
		this.ss = ss;
	}
	

}

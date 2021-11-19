package com.oqm.bean;

public class OqmBean {
	private String name;
	private String email;
	private String password;
	private String cpassword;
	private String mobileno;
	private String designation;
	public OqmBean()
	{
		super();
	}
	public OqmBean(String name, String email, String password, String cpassword, long mobileno, String designation)
	{
		
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getCpassword() 
	{
		return cpassword;
	}
	public void setCpassword(String cpassword) 
	{
		this.cpassword = cpassword;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String number) {
		this.mobileno = number;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
}

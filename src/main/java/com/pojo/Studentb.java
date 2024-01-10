package com.pojo;

import lombok.ToString;

@ToString
public class Studentb {

	private int Id;
	private String first_name;
	private String last_name;
	private String email;
	private long mobile;
	
	public Studentb() {}
	
	

	public int getId()
	{
		return Id;
	}
	
	public String getFirst_name()
	{
		return first_name;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public long getMobile()
	{
		return mobile;
	}



	public Studentb(int Id, String first_name, String last_name, String email, long mobile) {
		super();
		this.Id = Id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.mobile = mobile;
	}
}

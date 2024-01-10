package com.pojo;

public class StudentBuilder2 {

	private int Id;
	private String first_name;
	private String last_name;
	private String email;
	private long mobile;
	
	public  Studentb build()
	{
		
		return new Studentb(this.Id,this.first_name,this.last_name,this.email,this.mobile);
		
	}
	
	public static  StudentBuilder2 builder()
	{
		
		return new StudentBuilder2();
	}
	
	public StudentBuilder2 setId(int id)
	{
		this.Id=id;
		return this;
	}

	public StudentBuilder2 setFirst_name(String first_name) {
		this.first_name = first_name;
		return this;
	}

	public StudentBuilder2 setLast_name(String last_name) {
		this.last_name = last_name;
		return this;
	}

	public StudentBuilder2 setEmail(String email) {
		this.email = email;
		return this;
	}

	public StudentBuilder2 setMobile(long mobile) {
		this.mobile = mobile;
		return this;
	}
	
	public StudentBuilder2 and()
	{
		return this;
	}
	public StudentBuilder2 when()
	{
		return this;
	}
	public StudentBuilder2 then()
	{
		return this;
	}
}

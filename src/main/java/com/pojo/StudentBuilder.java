package com.pojo;

import lombok.Getter;

@Getter

public class StudentBuilder {

	private int id;
	private String frist_Name;
	private String last_Name;
	private String email;
	
	public  Student build()
	{
		return new Student(this.id,this.frist_Name,this.last_Name,this.email);
	}
	
	public static StudentBuilder builder()
	{
		return new StudentBuilder();
	}
	
	
	  public StudentBuilder setId(int id) {
		  
		  this.id=id; 
		  return this; 
		  }
	  
	  public StudentBuilder setfrist_Name(String frist_Name)
	  {
	  this.frist_Name=frist_Name; 
	  return this;
	  
	  }
	  
	  public StudentBuilder setlast_Name(String last_Name)
	  {
		  this.last_Name=last_Name;
		  return this;
	  }
	  
	  public StudentBuilder setemail(String email)
	  {
		  this.email=email;
		  return this;
	  }
	  
	  public StudentBuilder and()
	  {
		  return this;
	  }
	 public StudentBuilder when()
	 {
		 return this;
	 }
	 public StudentBuilder then()
	 {
		 return this;
	 }
	
	
}


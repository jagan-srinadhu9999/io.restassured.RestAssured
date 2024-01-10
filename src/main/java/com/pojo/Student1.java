package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Student1 {

	private int id;
	private String first_Name;
	private String last_Name;
	private String email;
	
	@Getter
	public static class StudentBuilder1{
		
		private int id;
		private String first_Name;
		private String last_Name;
		private String email;
		
		public static StudentBuilder1 builder()
		{
			
		return	new StudentBuilder1();
		}
		
		public Student1 build()
		{
			return new Student1(this.id,this.first_Name,this.last_Name,this.email); 
		}
		
		public StudentBuilder1 setId(int id)
		{
			this.id=id;
			return this;
		}
		
		public StudentBuilder1 setfirst_Name(String first_Name)
		{
			this.first_Name=first_Name;
			return this;
		}
	   public StudentBuilder1 setlast_Name(String last_Name)
	   {
		this.last_Name=last_Name;
		return this;
	   }
		
	  public StudentBuilder1 setemail(String email)
	  {
		this.email=email;
		return this;
	  }
	  
	  /*
	   * syntaxes sugars[it improves readability BDD format 
	   */
	  
	  public StudentBuilder1 and()
	  {
		  return this;
	  }
	  
	public StudentBuilder1 then()
	{
		return this;
	}
	
	public StudentBuilder1 when()
	{
		return this;
	}
	}
	
}

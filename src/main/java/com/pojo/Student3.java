package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Student3 {

	private int Id;
	private String first_name;
	private String last_name;
	private String email;
	private long mobile;
	
	
	public static class StudentBuilder3{
		private int Id;
		private String first_name;
		private String last_name;
		private String email;
		private long mobile;
		
		public Student3 build()
		{
			return new Student3(this.Id,this.first_name,this.last_name,this.email,this.mobile);
		}
		
		public static StudentBuilder3 builder()
		{
			
			return new StudentBuilder3();
		}
		
		public StudentBuilder3 setId(int Id)
		{
			this.Id=Id;
			return this;
			
		}
		
		public StudentBuilder3 setfirst_name(String first_name)
		{
			this.first_name=first_name;
			return this;
		}
		
		public StudentBuilder3 setlast_name(String last_name) {
			
			this.last_name=last_name;
			return this;
		}
		
		public StudentBuilder3 setemail(String email)
		{
			this.email=email;
			return this;
		}
		
	public StudentBuilder3 setmobile(long mobile) {
		this.mobile=mobile;
		return this;
	}
	
	}
	
	
}

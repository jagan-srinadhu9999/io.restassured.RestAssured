package com.pojo;

import java.util.List;

public class Employe {

	
	private int id;
	private String frst_name;
	private String last_name;
	private String email;
	private String mobile;
	private List<Marks> marks;
	private List<String> subjects;
	private Favfood favfood;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrst_name() {
		return frst_name;
	}
	public void setFrst_name(String frst_name) {
		this.frst_name = frst_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public List<Marks> getMarks() {
		return marks;
	}
	public void setMarks(List<Marks> marks) {
		this.marks = marks;
	}
	public List<String> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
	public Favfood getFavfood() {
		return favfood;
	}
	public void setFavfood(Favfood favfood) {
		this.favfood = favfood;
	}
	
	public Employe(int id, String frst_name, String last_name, String email, String mobile, List<Marks> marks,
			List<String> subjects, Favfood favfood) {
		
		super();
		this.id = id;
		this.frst_name = frst_name;
		this.last_name = last_name;
		this.email = email;
		this.mobile = mobile;
		this.marks = marks;
		this.subjects = subjects;
		this.favfood = favfood;
	}
	
	
	
		
}

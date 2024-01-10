package com.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@JsonPropertyOrder(value= {"id","frst_name","last_name"})
public class Employe1 {

	/*
	 * using lambok dependancy to eliminate boiler codes and import @Getter,@Setter,@AllArgsConstructors to insted of writing 
	 * manually just lambok will takecare of all of these things
	 */
	private int id;
	private String frst_name;
	private String last_name;
	private String email;
	private String mobile;
	private List<Marks1> marks;
	private List<String> subjects;
	private Favfood1 favfood;
	
	public Employe1() {}
	
	
	
	
	
	
	
		
}

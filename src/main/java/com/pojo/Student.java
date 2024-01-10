package com.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@Getter
@AllArgsConstructor
@ToString
@JsonInclude(value=Include.NON_NULL)
public class Student {

	private int id;
	private String frist_Name;
	private String last_Name;
	private String email;
	
	
	
}

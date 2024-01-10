package com.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class Favfood1 {

	private String breakfast;
	private String lunch;
	private List<String> dinner;
	
	public Favfood1() {}
}

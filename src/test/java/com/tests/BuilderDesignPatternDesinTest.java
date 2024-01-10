package com.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.pojo.Student;
import com.pojo.Student1;
import com.pojo.Student1.StudentBuilder1;
import com.pojo.Student2;
import com.pojo.Student3;
import com.pojo.Student3.StudentBuilder3;
import com.pojo.StudentBuilder;
import com.pojo.StudentBuilder2;
import com.pojo.Studentb;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class BuilderDesignPatternDesinTest {//Immutability

	//No parameters parameters increases the readabilty decreases.
	//If you want to exclude some fields, it is very difficult to create multiple constructors.
	
	//BuildeDesignpatterns --->External Builder , Static inner class
	
	//@Test
	public void test()
	{
		/*
		 * external builder class
		 */
		Student  student=StudentBuilder.builder()
				.when()
				.setId(9)
				.and()
				.setfrist_Name("jagan")
				.then()
				.setemail("sivasrinadh01@gmail.com").build();
		/*
		 * static inner builder class
		 */
		Student1 student1=
				Student1
				.StudentBuilder1
				.builder()
				.when()
		.setemail("sansatya234@gmail.com")
		.and()
		.setId(8)
		.and()
		.setfirst_Name("Kondappa")
		.and()
		.setlast_Name("Srinadhu")
		.then()
		.build();
		
		System.out.println(student);
		System.out.println(student1);
		
		Student2 student2=	Student2.builder().email("qwerty2123@gmail.com").frist_Name("srinadhu").last_Name("jagan").id(394).build();
		System.out.println(student2);
	
	}
	
	//@Test
	public void test1()
	{
		/*
		 * Extenal design pattern
		 */
		
		Studentb requestbody=	StudentBuilder2.builder()
		.when()
		.setId(45)
		.setFirst_name("bharth")
		.setEmail("bharthno1@gmail.com")
		.setMobile(+91).build();
		
		Response	response=	given()
		.baseUri("http://localhost:3000")
		.header("Content-Type","application/json; charset=utf-8")
		.log()
		.all()
		.body(requestbody)
		.post("/Employes");
		
		response.prettyPrint();
		
		Assertions.assertThat(response.statusCode())
		.isEqualTo(201);
		
		
		
	}
	
	@Test
	public void test2()
	{
		
		Student3 reqbody=Student3.StudentBuilder3.builder()
		.setId(394)
		.setfirst_name("india")
		.setemail("indiano1@gmail.com")
		.setmobile(+91).build();
		
		Response response=	given()
		.baseUri("http://localhost:3000")
		.header("Content-Type","application/json; charset=utf-8")
		.log()
		.all()
		.body(reqbody)
		.post("/Employes");
		response.prettyPrint();
		Assertions.assertThat(response.statusCode())
		.isEqualTo(201);
		
	}
}

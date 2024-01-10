package com.tests;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.hamcrest.Matcher;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.pojo.Employe1;
import com.pojo.Favfood1;
import com.pojo.Marks1;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
public class PojoPostCall1 {

	
	@Test
	public void getPostCall() throws IOException
	{
		
		
		List<String> subjects=new LinkedList<String>();
		subjects.add("S.O.M");
		subjects.add("fluid mechanics");
		subjects.add("engineering mechanics");
		
		List<String> dinner=new LinkedList<String>();
		dinner.add("chapathi");
		dinner.add("Kaddukakheer");
		dinner.add("curdrice");
		
		Favfood1 favfood=new Favfood1("idly", "rice", dinner);
		
		Marks1 firstsem=new Marks1(96,69,99,89,78,67,75,64,68);
		Marks1 secondsem=new Marks1(69,62,89,79,68,67,75,64,86);
		List<Marks1> marks=new LinkedList<Marks1>();
		marks.add(firstsem);
		marks.add(secondsem);
		
		Employe1 employe=new Employe1(new Faker().number().numberBetween(99, 9999), new Faker().name().firstName(),new Faker().name().lastName(), "jagan234@gmail.com", new Faker().phoneNumber().cellPhone(), marks, subjects, favfood);
		
		Response  response =	
		given()
		.header("Content-Type","application/json")
		.log()
		.all()
		.body(employe)
		.post("http://localhost:3000/Employes");
		
		
		
		
		
		System.out.println(response.prettyPrint());
	int statuscode=	response.statusCode();
	System.out.println(statuscode);
		Assert.assertEquals(response.statusCode(), statuscode);
		Assert.assertEquals(response.header("Content-Type"), "application/json; charset=utf-8");
		
		Employe1 deserializeresponse=	response.as(Employe1.class);//deserialize Json -> Object to byte stream
       Assert.assertEquals(deserializeresponse.getEmail(),"jagan234@gmail.com");
       Assert.assertEquals(response.jsonPath().getString("subjects[1]"), "fluid mechanics");
		Assert.assertEquals(response.jsonPath().getString("favfood.breakfast"),"idly");
		Assert.assertEquals(response.jsonPath().getString("favfood.dinner[0]"), "chapathi");
	
		System.out.println("Response Body: " + response.body().asString());
	String path=	System.getProperty("user.dir")+File.separator+"Resources"+File.separator+"schema.json";
	FileInputStream fis=new FileInputStream(path);	
	response.then().body(JsonSchemaValidator.matchesJsonSchema(fis));
		
		/*
		 * String expectedJson = FileUtils.readFileToString(new
		 * File("/src/test/resources/schema.json"));
		 * response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(
		 * expectedJson));
		 */
		
	}

	

	
	
	
}

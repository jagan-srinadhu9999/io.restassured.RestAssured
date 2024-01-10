package com.tests;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
public class GetCall {

	
//	@Test
	public void show()
	{
	Response response=	given().get("http://localhost:3000/Employes");
	response.prettyPrint();
	Headers  header=     response.headers();  
	
	for(Header headers : header)
	{
		System.out.println("header key :"+headers.getName() +" value: "+ headers.getValue());
		//System.out.println(headers.getClass());
	}
	
	System.out.println(response.statusCode());
	System.out.println(response.timeIn(TimeUnit.MILLISECONDS));
	
	
	}
	//@Test
	public void test() throws IOException
	{
		Response response=	given()
		.queryParam("id", 4)
		.log()
		.all()
		.get("http://localhost:3000/Employes");
		
	//response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));
		
		System.out.println("id :"+response.jsonPath().get("id"));
		System.out.println("frstname"+response.jsonPath().getString("first_Name"));
		
		/*
		 * to save the reponse in external file.
		 */
		Files.write(Paths.get(System.getProperty("user.dir")+"/response.json"),response.asByteArray());
	Assertions.assertThat(response.getStatusCode())
	.isEqualTo(200);
	Assertions.assertThat(response.jsonPath().getList("$").size())
	.isGreaterThan(30);
	
	Assertions.assertThat(response.jsonPath().getList("$")).size()
	.isLessThan(100);
	
	
	}
	
//	@Test
	public void assertions()
	{
		
		Response  response=	
				given()
		.baseUri("http://localhost:3000")
		.log()
		.all()
		.get("/Employes");
		
		System.out.println(response.statusCode());
		assertThat(response.statusCode())
		.isEqualTo(200)
		.isPositive();
		assertThat(response.jsonPath().getList("$").size())
		.isPositive()
		.as("return number of employes in response/else throw an exception")
		.isGreaterThan(60);
		
	}
	
	//@Test
	public void getEmployee()
	{
		
		Response response=	given()
		.baseUri("http://localhost:3000")
		.pathParam("id", "4")
		.log()
		.all()
		.get("/Employes/{id}");
		
		response.prettyPrint();
		
		assertThat(response.statusCode())
		.isEqualTo(200);
		
		assertThat(response.jsonPath().getString("first_Name"))
		.isEqualTo("pawan")
		.hasSizeBetween(2, 9);
		
		assertThat(response.jsonPath().getString("last_Nmae"))
		.isEqualTo("kalyan");
		
	}
	
	//@Test
	public void getCountry()
	{
		Response response=	given()
		.baseUri("http://localhost:3000")
		.pathParam("id", "45")
		.log().all()
		.get("/Employes/{id}");
		
		try {
			Files.write(Paths.get(System.getProperty("user.dir")+"/response1.json"),response.asByteArray());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		assertThat(response.statusCode())
		.isEqualTo(200)
		.isPositive();
		
		assertThat(response.jsonPath().getString("first_name"))
		.isEqualTo("bharth")
		.hasSizeBetween(1, 8);
	}
	@Test
	public void getCountry1()
	{
	Response response=	given()
		.baseUri("http://localhost:3000")
		.pathParam("id", 394)
		.log().all()
		.get("Employes/{id}");
	try {
	Files.write(Paths.get(System.getProperty("user.dir")+"./responsecountry.json"),response.asByteArray());
	}
	catch(IOException e){
		e.printStackTrace();
	}
	
	assertThat(response.statusCode())
	.isPositive()
	.isEqualTo(200);
	}
}

package com.tests;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostCall {

	// Passing json body as String ---> Not Recomended

//	@Test
	public void test() {
		String reqbody = "{\r\n" + "    \"id\": 4,\r\n" + "    \"first_Name\": \"srinadhu\",\r\n"
				+ "    \"last_Nmae\": \"jagan\",\r\n" + "    \"job\": \"QA Manual tester\",\r\n"
				+ "    \"email\": \"jagansrinadhu8@gmail.com\",\r\n" + "    \"mobile\": 6302521574,\r\n"
				+ "    \"author\": \"typicode\"\r\n" + "  }";

		Response response = given().header("Content-Type", ContentType.JSON).body(reqbody).log().all()
				.post("http://localhost:3000/Employes");

		response.prettyPrint();
		System.out.println(response.statusCode());

	}

	// @Test
	public void test1() {
		// pass it from the external fine
		// you can not get the request content body from the file and print it the
		// console
		// use this only static data

		Response response1 = given().header("Content-Type", ContentType.JSON).log().all()
				.body(new File(System.getProperty("user.dir") + "/reqbody1.json")).log().all()
				.post("http://localhost:3000/Employes");
		response1.prettyPrint();
		System.out.println(response1.statusCode());

	}

	//@Test
	public void test2() throws IOException {
//read the request body from the extenal file and convert the string
//1. logs the req body into the console
//2.change few parameters in the request
//3. Not suitable for request having lot of dynamic parameters
		
//	byte[] bytes=	Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/reqbody1.json"));
		String reqBody = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/reqbody1.json")));
		String responseBody = reqBody.replace("89", String.valueOf(new Faker().number().numberBetween(100, 1000)))
				               .replace("fname", new Faker().name().firstName())
				               .replace("lname", new Faker().name().lastName())
				               .replace("job", new Faker().job().field())
				               .replace("phonenumber",new Faker().phoneNumber().cellPhone());

		Response response = given().header("Content-Type", ContentType.JSON)
				.log()
				.all()
				.body(responseBody)
				.post("http://localhost:3000/Employes");

		response.prettyPrint();
		System.out.println(response.statusCode());

	}
	
	
	//@Test
	public void test3()
	{
		//using map and list from java
		// {} ----> Map interface
		// [] --> List
		//seriolisers ---> converts your language objects --> byte stream --> json
		// verbose and not suitable for very big json files
		// generic type needs to be mentioned
		
	   //	Map<String,Object> obj=new HashMap();
		Map<String,Object> obj=new LinkedHashMap();
		obj.put("id",new Faker().number().numberBetween(100, 10000));
		obj.put("first_Name", new Faker().name().firstName());
		obj.put("last_Name",new Faker().name().lastName());
		obj.put("work",new Faker().job().position());
		obj.put("email","jagansrinadhu8@gmail.com");
		obj.put("mobile",new Faker().phoneNumber().cellPhone());
		obj.put("author","typicode");
		obj.put("email", "sjm@gmail.com");
		
		//jobs is JsonArray so you need to choose as List Interface
		
		List<Object> listOfJobs = new ArrayList();
		listOfJobs.add("tester");
		listOfJobs.add("trainer");
		obj.put("jobs", listOfJobs);
		
		//favFoods is a JsonObject and inside JsonArray you need Map and List
		
		Map<String,Object> food=new LinkedHashMap<String, Object>();
		food.put("lunch","rice");
		food.put("breakfast","idly");
		List<Object> listOfFoods=new LinkedList<Object>();
		listOfFoods.add("chapathi");
		listOfFoods.add("milk");
		food.put("dinner", listOfFoods);
		
		obj.put("favFoods", food);
		
Response	reqBody=	given()
		.header("Content-Type",ContentType.JSON)
		.log()
		.all()
		.body(obj)
		.post("http://localhost:3000/Employes");
		
      reqBody.prettyPrint();
   System.out.println( reqBody.statusCode());
		
	}
	
	@Test
	public void test4()
	{
		//using external json liabrary
		//having same collections that can solve the problems we had while using map and list
		//{} --> JsonObject-->coming from org.json
		//[] --> JsonArray
		
		JSONObject obj=new JSONObject();
		obj.put("id",new Faker().number().numberBetween(100, 9999));
		obj.put("first_Name", new Faker().name().firstName());
		obj.put("last_Name",new Faker().name().lastName());
		obj.put("work",new Faker().job().position());
		obj.put("email","jagansrinadhu8@gmail.com");
		obj.put("mobile",new Faker().phoneNumber().cellPhone());
		obj.put("author","typicode");
		obj.put("email", "sjm@gmail.com");
		
		//jobs is json array so we allready use JSON liabray so we use JSONArray()
		
		JSONArray listofjobs=new JSONArray();
		listofjobs.put("tester");
		listofjobs.put("trainer");
		
		obj.put("jobs",listofjobs);
		
		//favfoods json object so we use JSON liabray JSONObject
		
		JSONObject food=new JSONObject();
		food.put("lunch","rice");
		food.put("breakfast", "idly");
		
		JSONArray listoffoods=new JSONArray();
		listoffoods.put("chapathi");
        listoffoods.put("milk");
        food.put("dinner", listoffoods);
        obj.put("favFoods", food);
		//we serialise JSONObject to Map interface
        Map<String, Object> obj1  =      obj.toMap();
		
	Response reqbody=	  given()
		  .header("Content-Type",ContentType.JSON)
		  .log()
		  .all()
		  .body(obj1) //we need serialise the JSONObject with jackson serialiser
		  .post("http://localhost:3000/Employes");
		  reqbody.prettyPrint();
		  System.out.println(reqbody.statusCode());
		
	}
}

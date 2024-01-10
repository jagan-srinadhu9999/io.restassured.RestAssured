package com.tests;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostCal {

	// @Test
	public void test() {

		String reqBody = "{\r\n" + "\"Id\":45,\r\n" + "\"fname\":\"joe\",\r\n" + "\"lname\":\"root\",\r\n"
				+ "\"email\":\"abc12@gmail.com\",\r\n" + "\"Mobile\":1234567899,\r\n"
				+ "\"subjects\":[\"S.O.M\",\"fluid mechanics\",\"engineering mechanics\"],\r\n" + "\"favfood\":{\r\n"
				+ "\"breakfast\":\"idly\",\r\n" + "\"lunch\":\"rice\",\r\n" + "\"dinner\":[\"chapathi\",\"milk\"]\r\n"
				+ "}\r\n" + "}\r\n" + "";
		Response response = given().header("Content-Type", ContentType.JSON).body(reqBody).log().all()
				.post("http://localhost:3000/Employes");
		response.prettyPrint();
		System.out.println(response.getStatusCode());

	}

//	@Test
	public void test1() {

		Response response = given().header("Content-Type", ContentType.JSON)
				.body(new File(System.getProperty("user.dir") + "/test.json")).log().all()
				.post("http://localhost:3000/Employes");

		response.prettyPrint();
		System.out.println(response.getStatusCode());
	}

//	@Test
	public void test2() throws Exception {
		// byte[] bytes=
		// Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/test.json"));
		String reqBody = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/test.json")));

		String responseBody = reqBody.replace("9", String.valueOf(new Faker().number().numberBetween(100, 1000)))
				.replace("fname", new Faker().name().firstName()).replace("lname", new Faker().name().lastName())
				.replace("mobile", String.valueOf(new Faker().phoneNumber().cellPhone()));

		Response response = given().header("Content-Type", ContentType.JSON).body(responseBody).log().all()
				.post("http://localhost:3000/Employes");

		response.prettyPrint();
		System.out.println(response.statusCode());
	}

	//@Test
	public void test3() {

		Map<String, Object> obj = new LinkedHashMap();

		obj.put("id", String.valueOf(new Faker().number().numberBetween(100, 999)));
		obj.put("frst_name", new Faker().name().firstName());
		obj.put("last_name", new Faker().name().lastName());
		obj.put("email", "abc12@gmail.com");
		obj.put("mobile", new Faker().phoneNumber().cellPhone());

		List<String> sub = new ArrayList<String>();
		sub.add("S.O.M");
		sub.add("fluid mechanics");
		sub.add("engineering mechanics");
		obj.put("subjects", sub);

		Map<String, Object> food = new LinkedHashMap();
		food.put("breakfast", "idly");
		food.put("lunch", "rice");
		List<String> listofFood = new ArrayList();
		listofFood.add("chapathi");
		listofFood.add("milk");
		food.put("food", listofFood);

		obj.put("favfood", food);

		Response response = given().header("Content-Type", ContentType.JSON).log().all().body(obj)
				.post("http://localhost:3000/Employes");

		response.prettyPrint();
		System.out.println(response.statusCode());
	}
     @Test
	public void test4() {
		
		  
    	
    	 
		 
		  JSONObject obj=new JSONObject();//add JSON java maven dependency in pom.xml
		  
		  
		  obj.put("id", String.valueOf(new Faker().number().numberBetween(100, 9999)));
			obj.put("frst_name", new Faker().name().firstName());
			obj.put("last_name", new Faker().name().lastName());
			obj.put("email", "abc12@gmail.com");
			obj.put("mobile", new Faker().phoneNumber().cellPhone());
			
			JSONArray sub=new JSONArray();
			sub.put("S.O.M");
			sub.put("fluid mechanics");
			sub.put("engineering mechanics");
			obj.put("subjects",sub);
			
			JSONObject food=new JSONObject();
			food.put("breakfast", "idly");
			food.put("lunch","rice");
			JSONArray listoffoods=new JSONArray();
			listoffoods.put("chapathi");
			listoffoods.put("milk");
			food.put("food",listoffoods );
			obj.put("favfood",food);
			 
			Map<String, Object> obj1=	obj.toMap();
			
	Response response=		given()
			.header("Content-Type",ContentType.JSON)
			.log()
			.all()
			.body(obj1)
			.post("http://localhost:3000/Employes")
			;
			
			response.prettyPrint();
			System.out.println(response.time());
			System.out.println(response.statusCode());
			
		  
	}

}

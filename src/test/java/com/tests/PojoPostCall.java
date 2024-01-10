package com.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import com.github.javafaker.Faker;
//import com.pojo.Employe;
import com.pojo.*;
import com.pojo.Favfood;
import com.pojo.Marks;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
public class PojoPostCall {

	@Test
	public void test() {
		
  List<String> subjects=new ArrayList<String>();
  subjects.add("S.O.M");
  subjects.add("fluid mechanics");
  subjects.add("engineering mechanics");
  
  Marks firstsem=new Marks(80,72,69,63,90,78,84,54,99);
  List<Marks> marks=new ArrayList<Marks>();
		
		marks.add(firstsem);
		List<String> dinner=new ArrayList<String>();
		dinner.add("chapathi");
		dinner.add("ragisankati");
		dinner.add("butter-milk");
Favfood favfood=	new Favfood("idly","rice",dinner);
		
		
Employe employe=new Employe(new Faker().number().numberBetween(1000, 10000),new Faker().name().firstName(),new Faker().name().lastName(),"sjm9999@gmail.com",new Faker().phoneNumber().cellPhone(),marks,subjects,favfood);
		 
Response response=	given()
		.header("Content-Type","application/json")
		.log().all()
		.body(employe)
		.post("http://localhost:3000/Employes");

String path=	System.getProperty("user.dir")+File.separator+"Resources"+File.separator+"schema.json";
FileInputStream fis;
try {
	fis = new FileInputStream(path);
	response.then().body(JsonSchemaValidator.matchesJsonSchema(fis));
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}	


System.out.println(response.statusCode());
System.out.println(response.prettyPrint());


	}
}

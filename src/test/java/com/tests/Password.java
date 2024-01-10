package com.tests;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Password {

	private String username;
	private String password;

	@JsonProperty("username")
	public String getUsername() {
		return username;
	}

	@JsonProperty("username")
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static void main(String[] args) throws IOException {
		ObjectMapper objectmapper = new ObjectMapper();

		// serialize
		Password creds = new Password();

		creds.setUsername("Srinadhu Jagan");
		creds.setPassword("Satysan@9999");
		try {
			String json = objectmapper.writeValueAsString(creds);
			System.out.println("serialize the json :" + json);
			// Deserialize
			Password deserializePassword = objectmapper.readValue(json, Password.class);
			System.out.println("Deserialize of json:" + deserializePassword);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

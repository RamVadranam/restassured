package com.vadranam.restassured.restassured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredTest {
	
	@Test
	public void postData() {
		
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type","application/json");
		
		JSONObject object = new JSONObject();
		object.put("id", 2);
		object.put("author", "rc123");
		object.put("title", "json-server");
		
		request.body(object.toJSONString());
		
		Response response = request.post("http://localhost:3000/posts");
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode,201);
		
	}
	
	@Test 
	public void updateData() {
		
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type","application/json");
		
		JSONObject object = new JSONObject();
		object.put("id", 2);
		object.put("author", "ram");
		object.put("title", "json-server");
		
		request.body(object.toJSONString());
		
		Response response = request.put("http://localhost:3000/posts/2");
		
		int code = response.getStatusCode();
		
		Assert.assertEquals(code, 200);
	}

}

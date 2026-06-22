package com.test;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

@Test
public class LoginTest {
	public void loginTest() {
		JSONObject payload=new JSONObject();
		payload.put("email","sam@gmail.com");
		payload.put("password", "123");
		Response response = RestAssured
		        .given()
		        .contentType(ContentType.JSON)
		        .body(payload.toString())
		        .when()
		        .post("https://lms-server-3-wedg.onrender.com/user/login");

		response.then()
		        .statusCode(201)
		        .log().all();
	}
	
	@Test
	public void invalidEmailTest() {

	    JSONObject payload = new JSONObject();
	    payload.put("email", "sa@gmail.com");
	    payload.put("password", "123");

	    Response response = RestAssured
	            .given()
	            .contentType(ContentType.JSON)
	            .body(payload.toString())
	            .when()
	            .post("https://lms-server-3-wedg.onrender.com/user/login");

	    Assert.assertEquals(response.getStatusCode(), 400);

	    String actualError =response.jsonPath().getString("message[0].value");

	    Assert.assertEquals(actualError, "Email is invalid");

	    response.prettyPrint();
	}
	@Test
	public void wrongPasswordTest() {

	    JSONObject payload = new JSONObject();
	    payload.put("email", "sam@gmail.com");
	    payload.put("password", "111");

	    Response response = RestAssured
	            .given()
	            .contentType(ContentType.JSON)
	            .body(payload.toString())
	            .when()
	            .post("https://lms-server-3-wedg.onrender.com/user/login");

	    Assert.assertEquals(response.getStatusCode(), 400);

	    String actualError =response.jsonPath().getString("message[0].value");

	    Assert.assertEquals(actualError, "Password is incorrect");

	    response.prettyPrint();
	}
	
	@Test
	public void missingPasswordTest() {

	    JSONObject payload = new JSONObject();
	    payload.put("email", "sam@gmail.com");

	    Response response = RestAssured
	            .given()
	            .contentType(ContentType.JSON)
	            .body(payload.toString())
	            .when()
	            .post("https://lms-server-3-wedg.onrender.com/user/login");

	    Assert.assertEquals(response.getStatusCode(), 400);

	    String actualError =response.jsonPath().getString("message[0].value");

	    Assert.assertEquals(actualError, "All fields are required");

	    response.prettyPrint();
	}
}

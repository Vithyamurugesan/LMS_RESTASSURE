package com.test;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

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
}

package com.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@Test
public class GetDataTest {
	public void getDataTest() {
		Response response = RestAssured
		        .given()
		        .contentType(ContentType.JSON)
		        .when()
		        .get("https://lms-server-3-wedg.onrender.com/");
		response.then()
		        .statusCode(200)
		        .log().all();
	}
}
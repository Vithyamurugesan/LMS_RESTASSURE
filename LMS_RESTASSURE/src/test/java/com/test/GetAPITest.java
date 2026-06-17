package com.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAPITest {
  @Test
  public void apiRun() {
	  Response response=RestAssured.given()
			  .when().get("https://lms-server-3-wedg.onrender.com");
	  response.then().statusCode(200);
	  System.out.println("API Running...");
  }
}

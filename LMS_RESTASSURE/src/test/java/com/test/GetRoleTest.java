package com.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRoleTest {

    @Test
    public void getRoleTest() {

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://lms-server-3-wedg.onrender.com/roles/getAll");

      System.out.println(response.asPrettyString());
      System.out.println(response.getStatusCode());

        response.then()
                .statusCode(200)
                .log().all();
    }
}
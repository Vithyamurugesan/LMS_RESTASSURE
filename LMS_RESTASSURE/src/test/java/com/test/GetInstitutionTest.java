package com.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetInstitutionTest {

    @Test
    public void getInstitutionTest() {

        Response response = RestAssured
                .given()
                .when()
                .get("https://lms-server-3-wedg.onrender.com/getAll/institution");

        response.then()
                .statusCode(200)
                .log().all();
    }

}
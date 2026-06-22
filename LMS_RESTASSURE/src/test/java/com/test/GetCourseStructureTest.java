package com.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetCourseStructureTest extends BaseTest {

    @Test
    public void getCourseStructureTest() {

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + getToken())
                .when()
                .get(BASE_URL + "/courses-structure/getAll");

        response.then()
                .statusCode(200)
                .log().all();
    }
}
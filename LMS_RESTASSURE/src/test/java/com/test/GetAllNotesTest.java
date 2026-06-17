package com.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllNotesTest extends BaseTest {

    @Test
    public void getAllNotesTest() {

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + getToken())
                .queryParam("limit", 2)
                .queryParam("sortOrder", "desc")
                .when()
                .get(BASE_URL + "/getAll/notes");

        response.then()
                .statusCode(200)
                .log().all();

    }

}
package com.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRoleTest extends BaseTest {

    @Test
    public void getRoleTest() {

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + getToken())
                .when()
                .get(BASE_URL + "/roles/getAll");

        response.then()
                .statusCode(200)
                .log().all();

    }

}
package com.test;

import java.util.List;

import org.testng.Assert;
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

        Assert.assertEquals(response.getStatusCode(), 200);

        String message =response.jsonPath().getString("message[0].value");

        Assert.assertEquals(message,"Role Retrieved successfully");

        List<Object> roles =response.jsonPath().getList("roles");

        Assert.assertTrue(roles.size() > 0,"Roles list is empty");

        response.prettyPrint();
        
    }
    
    @Test
    public void getRoleWithoutTokenTest() {

        Response response = RestAssured
                .given()
                .when()
                .get(BASE_URL + "/roles/getAll");

        Assert.assertEquals(response.getStatusCode(),401);

        String error =response.jsonPath().getString("message[0].value");

        Assert.assertEquals(error,"User is not logged in");

        response.prettyPrint();
    }
}

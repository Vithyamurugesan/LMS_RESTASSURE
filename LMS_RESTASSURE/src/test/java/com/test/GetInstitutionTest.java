package com.test;

import java.util.List;

import org.testng.Assert;
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

        Assert.assertEquals(response.getStatusCode(), 200);
        List<Object> institutions =response.jsonPath().getList("getAllInstitution");
        Assert.assertTrue(institutions.size() > 0,"Institution list is empty");
        response.prettyPrint();
    }
}
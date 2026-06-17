package com.test;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateNoteTest extends BaseTest {

    public static String noteId;

    @Test
    public void createNoteTest() {

        JSONObject payload = new JSONObject();

        payload.put("title", "API Test Note");
        payload.put("content", "Created by Tester");
        payload.put("color", "#ffeb3b");
        payload.put("isPinned", false);

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + getToken())
                .header("Content-Type", "application/json")
                .body(payload.toString())
                .when()
                .post(BASE_URL + "/create/notes");

        noteId = response.jsonPath().getString("data._id");

        System.out.println("Created Note Id : " + noteId);

        response.then()
                .statusCode(201)
                .log().all();

    }

}
package com.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetNoteByIdTest extends BaseTest {

    @Test
    public void getNoteByIdTest() {

        CreateNoteTest create = new CreateNoteTest();
        create.createNoteTest();

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + getToken())
                .when()
                .get(BASE_URL + "/getById/notes/" + CreateNoteTest.noteId);

        response.then()
                .statusCode(200)
                .log().all();

    }

}
package com.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TogglePinTest extends BaseTest {

    @Test
    public void togglePinTest() {

        CreateNoteTest create = new CreateNoteTest();
        create.createNoteTest();

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + getToken())
                .when()
                .put(BASE_URL + "/toggle-pin/notes/" + CreateNoteTest.noteId);

        response.then()
                .statusCode(200)
                .log().all();

    }

}
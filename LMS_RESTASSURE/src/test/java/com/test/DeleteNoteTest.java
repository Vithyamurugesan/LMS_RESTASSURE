package com.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteNoteTest extends BaseTest {

    @Test
    public void deleteNoteTest() {

        CreateNoteTest create = new CreateNoteTest();
        create.createNoteTest();

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + getToken())
                .when()
                .delete(BASE_URL + "/delete/notes/ById/" + CreateNoteTest.noteId);

        response.then()
                .statusCode(200)
                .log().all();

    }

}
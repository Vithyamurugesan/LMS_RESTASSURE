package com.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllNotesTest extends BaseTest {

	@Test
	public void getAllNotes() {

	    Response response = RestAssured
	            .given()
	            .header("Authorization", "Bearer " + getToken())
	            .when()
	            .get(BASE_URL + "/getAll/notes");

	    Assert.assertEquals(response.getStatusCode(), 200);

	    Assert.assertTrue(response.jsonPath().getBoolean("success"));

	    List<String> titles =response.jsonPath().getList("data.title");

	    System.out.println("NOTES");

	    for(String title : titles) {
	        System.out.println(title);
	    }
	    response.prettyPrint();
	}
	@Test
	public void getAllNoteWithParamTest() {

	    Response response = RestAssured
	            .given()
	            .header("Authorization", "Bearer " + getToken())
	            .queryParam("page", 1)
	            .queryParam("limit", 50)
	            .queryParam("search", "API")
	            .queryParam("tags", "qa")
	            .queryParam("isPinned", false)
	            .queryParam("sortBy", "lastEdited")
	            .queryParam("sortOrder", "desc")
	            .when()
	            .get(BASE_URL + "/getAll/notes");

	    Assert.assertEquals(response.getStatusCode(), 200);

	    Boolean success =response.jsonPath().getBoolean("success");

	    Assert.assertTrue(success);

	    response.prettyPrint();
	}
	@Test
	public void getAllNotesWithNegativePageTest() {

	    Response response = RestAssured
	            .given()
	            .header("Authorization", "Bearer " + getToken())
	            .queryParam("page", -1)
	            .when()
	            .get(BASE_URL + "/getAll/notes");

	    response.prettyPrint();
	}

}
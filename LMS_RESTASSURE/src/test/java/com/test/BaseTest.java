package com.test;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseTest {

    String BASE_URL ="https://lms-server-3-wedg.onrender.com";
    String token;
    String noteId;
   
    public String getToken() {
    	JSONObject payload = new JSONObject();
    	payload.put("email","sam@gmail.com");
    	payload.put("password","123");

        if (token == null) {
            Response response = RestAssured
                    .given()
                    .header("Content-Type", "application/json")
                    .body(payload.toString())
                    .when()
                    .post(BASE_URL + "/user/login");

            token = response.jsonPath().getString("token");
        }

        return token;
    }
}
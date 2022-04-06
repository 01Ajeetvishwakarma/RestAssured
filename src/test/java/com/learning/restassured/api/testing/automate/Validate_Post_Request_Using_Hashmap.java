package com.learning.restassured.api.testing.automate;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Validate_Post_Request_Using_Hashmap {

    @BeforeClass
    private void setUp() {

        RestAssured.requestSpecification = given()
                .log().all()
                .contentType(ContentType.JSON)
                .baseUri("http://localhost:8080")
                .basePath("/bookService");

        RestAssured.responseSpecification = RestAssured.expect().statusCode(201)
                .contentType(ContentType.JSON)
                .log().all();
    }

    @Test
    public void validate_Post_Request_Using_Hashmap()
        {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", "12");
            map.put("title", "y");
            map.put("pages", "12");
            map.put("authors", Arrays.asList("xy", "yz"));

            Response response = given().contentType(ContentType.JSON)
                    .body(map)
                    .post("/books");
        }
}

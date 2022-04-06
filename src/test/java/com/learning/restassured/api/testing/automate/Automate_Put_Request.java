package com.learning.restassured.api.testing.automate;

import com.learning.restassured.api.testing.common.Customer_Base_Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static java.lang.System.getProperties;

public class Automate_Put_Request {

    @BeforeClass
    private void setUp()
        {
            RestAssured.requestSpecification = given()
            .log().all()
            .contentType(ContentType.JSON)
            .baseUri("http://localhost:8080")
            .basePath("/bookService");

            RestAssured.responseSpecification = RestAssured.expect()
            .statusCode(201)
            .contentType(ContentType.JSON).log().all();
        }

    @Test
    public void automate_Put_Request()
        {
            String body = "{ \"id\": 13,\n" +
                    "        \"title\": \"lion \",\n" +
                    "        \"pages\": 5, \n" +
                    "        \"authors\": [\"X1\", \"Y1\"]}";

            given().body(body)
            .contentType(ContentType.JSON)
            .put("/books")
            .then();
        }
}

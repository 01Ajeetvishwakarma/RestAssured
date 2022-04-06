package com.learning.restassured.api.testing.automate;

import com.learning.restassured.api.testing.common.Customer_Base_Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.*;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Automate_Patch_Request  {


    @BeforeClass
    private void setUp() throws IOException {
        RestAssured.requestSpecification = given()
                .log().all()
                .contentType(ContentType.JSON)
                .baseUri("http://localhost:8080")
                .basePath("/bookService");

        RestAssured.responseSpecification = RestAssured.expect().statusCode(201)
                .contentType(ContentType.JSON).log().all();
    }


        @Test
    public void automate_Patch_Request()
        {
            String body = "{\"title\": \"Spring  \"}";

            given().contentType(ContentType.JSON)
            .pathParam("id",4)
            .body(body)
            .patch("/book/{id}");
        }

}

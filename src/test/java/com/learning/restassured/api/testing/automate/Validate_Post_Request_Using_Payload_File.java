package com.learning.restassured.api.testing.automate;

import com.learning.restassured.api.testing.common.Customer_Base_Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.*;

import java.io.File;

import static io.restassured.RestAssured.*;
public class Validate_Post_Request_Using_Payload_File {

    @BeforeClass
    private void setUp()
        {
            requestSpecification = given()
                    .log().all()
                    .contentType(ContentType.JSON)
                    .baseUri("http://localhost:8080")
                    .basePath("/bookService");
            //#################################################################
            RestAssured.responseSpecification = RestAssured.expect().statusCode(201)
                    .contentType(ContentType.JSON)
                    .log().all();
        }


    @Test
    public void validate_Post_Request_In_Bdd_Style_Using_Payload_File() {

        given().body(new File("src/test/resources/books_payload.json"))
                .contentType(ContentType.JSON)
                .post("/books")
                .then()
                .log().all();
    }

}

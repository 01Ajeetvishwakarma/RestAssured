package com.learning.restassured.api.testing.automate;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class Automate_Post_Request {


    @BeforeClass
    private void setUp() {
        RestAssured.requestSpecification = given()
                //.auth().basic(getProperties().getProperty("secretKey"), "")
                .log().all()
                .contentType(ContentType.JSON)
                .baseUri("http://localhost:8080")
                .basePath("/bookService");

        RestAssured.responseSpecification = RestAssured.expect().statusCode(201)
                .contentType(ContentType.JSON).log().all();
    }


        @Test
    public void validate_Post_Request_In_Bdd_Style() {

//        String body = "{\"name\": \"Ajeet23\",\n" +
//                "\"email\": \"ajeet23@gmail.com\",\n" +
//                "\"description\": \"abcd\"}";

        String body = "{ \"id\": 9,\n" +
                "        \"title\": \"action jackson AAAAAAAA\",\n" +
                "        \"pages\": 7, \n" +
                "        \"authors\": [\"A1\", \"B1\"]}";

        given().body(body)
                .contentType(ContentType.JSON)
                .post("/books")
                .then()
                .log().all();
//                .body("name",equalTo("Ajeet23"));
    }

    @Test
    public void validate_Post_Request_In_Non_Bdd_Style() {

        String stringBody = "{ \"id\": 10,\n" +
                "        \"title\": \"action jackson BBBB\",\n" +
                "        \"pages\": 10, \n" +
                "        \"authors\": [\"A2\", \"B2\"]}";

       /* Response response =*/ with().body(stringBody)
                .post("/books");
       // assertThat(response.path("title"),equalTo("action jackson BBBB"));


    }
}
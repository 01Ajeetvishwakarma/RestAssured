package com.learning.restassured.api.testing.patch;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class Patch_Request
{
    public static void main(String[] args) {

        String bodyString = "{ \"title\": \"Action Jackson\"}";

       Response response = given().contentType(ContentType.JSON)
               .pathParams("id",2)
               .body(bodyString)
                .patch("http://localhost:8080/bookService/book/{id}");

       response.prettyPrint();
       System.out.println("Status code : "+ response.getStatusCode());
    }
}

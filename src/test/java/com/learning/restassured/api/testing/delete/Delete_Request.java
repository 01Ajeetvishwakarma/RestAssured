package com.learning.restassured.api.testing.delete;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class Delete_Request
{
    public static void main(String[] args) {



      Response response =  given().contentType(ContentType.JSON)
                .pathParam("id",2)
                .delete("http://localhost:8080/bookService/book/{id}");

      response.prettyPrint();
      System.out.println(response.getStatusCode());
    }
}

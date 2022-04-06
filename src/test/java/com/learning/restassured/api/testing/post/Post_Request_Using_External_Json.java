package com.learning.restassured.api.testing.post;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.io.File;

public class Post_Request_Using_External_Json
{
    public static void main(String[] args)
    {
      Response response = given().contentType(ContentType.JSON).body(new File("externaljson.json"))
               .post("http://localhost:8080/bookService/books");
      response.prettyPrint();
      System.out.println("Status code : "+response.getStatusCode());
    }

}

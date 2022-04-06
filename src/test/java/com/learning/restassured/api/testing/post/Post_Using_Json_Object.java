package com.learning.restassured.api.testing.post;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class Post_Using_Json_Object {
    public static void main(String[] args) {

        JSONArray ja = new JSONArray();
        ja.put("Author 1");
        ja.put("Author 2");

        JSONObject j = new JSONObject();
        j.put("id","4");
        j.put("title","JSON IN ACTION");
        j.put("pages","2332");
        j.put("author",ja);

       Response response = given().
                pathParams("id",1)
               .contentType(ContentType.JSON)
               .body(j)
                .post("http://localhost:8080/bookService/book/{id}");

       response.prettyPrint();
       System.out.println("Status Code : "+response.getStatusCode());
    }
}

package com.learning.restassured.api.testing.post;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import java.util.Arrays;
import java.util.HashMap;

public class Post_Complex_Json {
    public static void main(String[] args) {

        String bodyString = " {\n" +
                "        \"id\": 8,\n" +
                "        \"title\": \"action jackson\",\n" +
                "        \"pages\": 7,\n" +
                "        \"authors\": [\n" +
                "            \"A\",\n" +
                "            \"B\"\n" +
                "        ]\n" +
                "    }";

        HashMap<String, Object> map = new HashMap<>();
        map.put("id","10");
        map.put("title","x");
        map.put("pages","40");
        map.put("authors", Arrays.asList("asdf","xyz").toString());

       Response response = given()
                .body(bodyString)
                .contentType(ContentType.JSON)
                .post("http://localhost:8080/bookService/books");

       response.prettyPrint();
       System.out.println("status code : "+response.getStatusCode());
    }
}

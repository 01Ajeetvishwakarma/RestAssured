package com.learning.restassured.api.testing.post;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Send_Post_Request_Using_RestAssured {
    public static void main(String[] args) {


//
//        Response response = given().auth().basic("sk_test_51K901RSASrG4w5rMEEivfT8zYBbOrCfHs4JcRR46VK2jBlr7NWaXCsfP3DkdN6nthcCRrUW8U2rUfQg7oeJ12g5U009iuWPzUM","")
//                .contentType(ContentType.JSON)
//                .formParam("name","Aman")
//                .formParam("email","aman.verma@walkingtree.tech")
//                .post("https://api.stripe.com/v1/customers");

        String bodyString = " {\n" +
                "        \"id\": 7,\n" +
                "        \"title\": \"SpringBoot in Super action\",\n" +
                "        \"pages\": 70,\n" +
                "        \"authors\": [\n" +
                "            \"Ajit\",\n" +
                "            \"abhishake\"\n" +
                "        ]\n" +
                "    }";

        HashMap<String, String> h = new HashMap<>();
        h.put("id","8");
        h.put("title","x");
        h.put("pages","0");
        h.put("authors", Arrays.asList("x","x").toString());

       Response response = given().contentType(ContentType.JSON)
               .body(bodyString)
               .post("http://localhost:8080/bookService/books");
        System.out.println(response.prettyPrint());
        System.out.println("Response code : "+response.getStatusCode());
    }
}

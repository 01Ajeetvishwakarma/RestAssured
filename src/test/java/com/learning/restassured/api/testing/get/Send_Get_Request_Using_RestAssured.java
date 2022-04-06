package com.learning.restassured.api.testing.get;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Send_Get_Request_Using_RestAssured {
    public static void main(String[] args) {

//        Response responce = given().contentType(ContentType.JSON).log().all().get("http://localhost:8080/bookService/books");
//        responce.prettyPrint();

       Response res= given().contentType(ContentType.JSON)
               .auth()
               .basic("sk_test_51K901RSASrG4w5rMEEivfT8zYBbOrCfHs4JcRR46VK2jBlr7NWaXCsfP3DkdN6nthcCRrUW8U2rUfQg7oeJ12g5U009iuWPzUM","")
               .get("https://api.stripe.com/v1/customers");
       res.prettyPrint();

    }
}

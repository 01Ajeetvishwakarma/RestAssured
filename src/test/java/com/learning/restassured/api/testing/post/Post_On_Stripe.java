package com.learning.restassured.api.testing.post;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class Post_On_Stripe {
    public static void main(String[] args) {

       Response response = given()
               .auth()
                .basic("sk_test_51K901RSASrG4w5rMEEivfT8zYBbOrCfHs4JcRR46VK2jBlr7NWaXCsfP3DkdN6nthcCRrUW8U2rUfQg7oeJ12g5U009iuWPzUM","")
                .formParam("name","x")
                .formParam("email","x@x.com")
                .formParam("description","xyz")
                .post("https://api.stripe.com/v1/customers");


        response.prettyPrint();
        System.out.println("Response code : "+response.getStatusCode());

    }
}

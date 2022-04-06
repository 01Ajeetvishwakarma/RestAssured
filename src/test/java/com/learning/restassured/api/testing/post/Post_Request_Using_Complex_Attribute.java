package com.learning.restassured.api.testing.post;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Post_Request_Using_Complex_Attribute {
    public static void main(String[] args) {

      Response response = given().auth()
                .basic("sk_test_51K901RSASrG4w5rMEEivfT8zYBbOrCfHs4JcRR46VK2jBlr7NWaXCsfP3DkdN6nthcCRrUW8U2rUfQg7oeJ12g5U009iuWPzUM","")
                .formParam("name","Ajeet22")
                .formParam("email","a@gmail.com")
                .formParam("description","xxxxxxxxxxxxx")
                .formParam("address[city]","Agra")
                .formParam("address[country]","India")
                .formParam("address[line1]","colony")
                .formParam("address[line2]","colony")
                .formParam("address[postal_code]","202007")
                .formParam("address[state]","Utter Pradesh")
                .formParam("preferred_locales[0]","South")
                .formParam("preferred_locales[1]","North")
                .post("https://api.stripe.com/v1/customers");

      response.prettyPrint();
      System.out.println("Status Code: "+response.getStatusCode());

        JsonPath jsonPath = response.jsonPath();
        System name = jsonPath.get("name");
        System.out.println(name);

//        if (name.equals("Ajeet22")&& response.getStatusCode()==200)
////        {
////            System.out.println("Validate Successfully");
////        }
////        else
////        {
////            System.out.println("Validation Failed");
////        }

    }
}

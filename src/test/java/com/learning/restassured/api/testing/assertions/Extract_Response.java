package com.learning.restassured.api.testing.assertions;

import com.learning.restassured.api.testing.common.Customer_Base_Test;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.form;
import static io.restassured.RestAssured.given;

public class Extract_Response extends Customer_Base_Test {

    @Test
  public void   extract_Response() {

      Response response = given()
                .auth()
                .basic(getProperties().getProperty("secretKey"), "")
                .when()
                .get(getProperties().getProperty("customerEndPoint"))
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        JsonPath jsonPath = new JsonPath(response.asString());
        System.out.println("data.name"+ jsonPath.getString("data.name"));
    }

    @Test
   public void automate_Get_Request_Extract_Response()
    {
      Response response =  given()
                .auth()
                .basic(getProperties().getProperty("secretKey"), "")
                .when()
                .get(getProperties().getProperty("customerEndPoint"))
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        System.out.println("data.name"+ response.path("data.name"));
    }

}

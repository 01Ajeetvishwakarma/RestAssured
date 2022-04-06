package com.learning.restassured.api.testing.assertions;

import com.learning.restassured.api.testing.common.Customer_Base_Test;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Assert_On_Extract_Response_Single_Customer_EndPoint extends Customer_Base_Test {

//    @BeforeClass
//    public void setUp()
//    {
//        RestAssured.baseURI = "https://api.stripe.com";
//        RestAssured.basePath = "/v1";
//    }


    @Test
    public void assert_On_Extract_Response_Single_Response() {

//        RestAssured.baseURI = "https://api.stripe.com";
//        RestAssured.basePath = "/v1";

        given()
                .auth()
                .basic(getProperties().getProperty("secretKey"), "")
                .when()
                .get("/customers/cus_KqtqrFR4Gfdv6c")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response()
                .path("data.name");

    }
}

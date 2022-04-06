package com.learning.restassured.api.testing.request_parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Automate_Single_Query_Parameter_Request
    {

        @Test
        public void single_Query_Parameter()
            {
                given().baseUri("https://postman-echo.com")
                        .queryParam("name","ajeet")
                        .log().all()
                        .when().get("/get")
                        .then().log().all()
                        .assertThat().statusCode(200);
            }

    }

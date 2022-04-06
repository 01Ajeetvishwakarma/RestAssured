package com.learning.restassured.api.testing.request_parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Multi_Value_Query_Parameter {

    @Test
    public void multi_Value_Query_Parameter()
    {
        given().baseUri("https://postman-echo.com")
                .queryParam("hobby","playing, reading")
                .log().all()
                .when().get("/get")
                .then().log().all()
                .assertThat().statusCode(200);
    }

}

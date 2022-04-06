package com.learning.restassured.api.testing.request_parameters;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Automate_Multi_Query_Parameter_Request {

    @Test
    public void multi_Query_Parameter()
    {
        given().baseUri("https://postman-echo.com")
                .queryParam("name2","ajeet2")
                .log().all()
                .when().get("/get")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void multi_Query()
    {
        HashMap<String, String> params = new HashMap<>();
        params.put("name3","ajeet3");
        params.put("name4","ajeet4");
        params.put("name5","ajeet5");
        params.put("name6","ajeet6");

        given().baseUri("https://postman-echo.com")
                .queryParam(String.valueOf(params))
               .log().all().when()
                .get("/get")
                .then().log().all()
                .assertThat().statusCode(200);
    }
}

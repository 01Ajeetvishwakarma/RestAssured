package com.learning.restassured.api.testing.request_parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Multi_Part_Data {

    @Test
   public void multipart_Data()
    {
        given().baseUri("https://postman-echo.com")
                .multiPart("name1","ajeet1")
                .multiPart("name2","ajeet2")
                .multiPart("name3","ajeet3")
                .log().all()
                .when().post("/post")
                .then().log().all()
                .assertThat().statusCode(200);
    }

}

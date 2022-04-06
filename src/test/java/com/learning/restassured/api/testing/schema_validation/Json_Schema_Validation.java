package com.learning.restassured.api.testing.schema_validation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import  static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Json_Schema_Validation
    {

        @Test
        public void json_Schema_Validation()
            {
                given().baseUri("https://postman-echo.com")
                        .log().all()
                        .when()
                        .get("/get")
                        .then()
                        .log().all()
                        .assertThat().statusCode(200)
                        .body(matchesJsonSchemaInClasspath("EchoGetAPISchema.json"));
            }

    }

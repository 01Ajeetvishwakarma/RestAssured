package com.learning.restassured.api.testing.request_parameters;

import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

public class Form_Url_Encoded {

    @Test
    public void form_Url_Encoded()
        {
            given().baseUri("https://postman-echo.com")
                    .contentType(ContentType.URLENC)
                    .config(config().encoderConfig(EncoderConfig.encoderConfig()
                            .appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                    .formParam("key1","value1")
                    .formParam("key2","value2")
                    .log().all()
                    .when().post("/post")
                    .then().log().all()
                    .assertThat().statusCode(200);
        }

}

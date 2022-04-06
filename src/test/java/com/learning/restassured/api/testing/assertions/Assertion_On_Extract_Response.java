package com.learning.restassured.api.testing.assertions;

import com.learning.restassured.api.testing.common.Customer_Base_Test;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class Assertion_On_Extract_Response extends Customer_Base_Test {

    @Test
    public void assert_On_Extract_Response()
    {
        given()
                .auth()
                .basic(getProperties().getProperty("secretKey"), "")
                .when()
                .get(getProperties().getProperty("EndPoint"))
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();
    }

    @Test
    public void assertion_on_extracted_response(){
        String response = given().auth().basic(getProperties().getProperty("secretKey"), "")
                .when()
                .get(getProperties().getProperty("EndPoint"))
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response().path("data[0].name");
        assertThat("culprits4",equalTo(response));

    }

}

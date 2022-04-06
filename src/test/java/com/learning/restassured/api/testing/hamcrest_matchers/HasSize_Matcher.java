package com.learning.restassured.api.testing.hamcrest_matchers;

import com.learning.restassured.api.testing.common.Customer_Base_Test;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class HasSize_Matcher extends Customer_Base_Test {

    @Test
    public void hasSizeMatcherTest()
    {
        given().auth()
                .basic(getProperties().getProperty("secretKey"), "")
                .when()
                .get(getProperties().getProperty("EndPoint"))
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .body("data.name",hasSize(7));

    }
}

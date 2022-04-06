package com.learning.restassured.api.testing.hamcrest_matchers;

import com.learning.restassured.api.testing.common.Customer_Base_Test;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasValue;

public class HasValue_Matcher extends Customer_Base_Test {

    @Test
    public void hasValueMatcherTest()
    {
        given().auth()
                .basic(getProperties().getProperty("secretKey"), "")
                .when()
                .get(getProperties().getProperty("EndPoint"))
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .body("data[0]",hasValue("Ajeet22") );

    }

}

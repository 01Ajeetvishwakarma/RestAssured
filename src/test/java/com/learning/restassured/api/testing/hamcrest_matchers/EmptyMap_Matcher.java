package com.learning.restassured.api.testing.hamcrest_matchers;

import com.learning.restassured.api.testing.common.Customer_Base_Test;
import org.testng.annotations.Test;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class EmptyMap_Matcher extends Customer_Base_Test {

    @Test
    public void emptyMapMatcherTest()
    {
        given().auth()
                .basic(getProperties().getProperty("secretKey"), "")
                .when()
                .get(getProperties().getProperty("EndPoint"))
                .then()
                .log().ifError()
                .assertThat().statusCode(200)
                .body("data[0]",not(equalTo(Collections.EMPTY_MAP)) );
    }
}

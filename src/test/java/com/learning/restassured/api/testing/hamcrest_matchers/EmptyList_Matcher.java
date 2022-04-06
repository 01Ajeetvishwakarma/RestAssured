package com.learning.restassured.api.testing.hamcrest_matchers;

import com.learning.restassured.api.testing.common.Customer_Base_Test;
import org.testng.annotations.Test;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class EmptyList_Matcher extends Customer_Base_Test {

    @Test
    public void emptyListMatcherTest()
    {
        given().auth()
                .basic(getProperties().getProperty("secretKey"), "")
                .when()
                .get(getProperties().getProperty("EndPoint"))
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .body("data.name",equalTo(Collections.EMPTY_LIST) );
    }

}

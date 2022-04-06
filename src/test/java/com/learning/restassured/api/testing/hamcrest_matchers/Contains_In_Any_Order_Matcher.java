package com.learning.restassured.api.testing.hamcrest_matchers;

import com.learning.restassured.api.testing.common.Customer_Base_Test;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class Contains_In_Any_Order_Matcher extends Customer_Base_Test {

    @Test
    public void containsInAnyOrderTest()
    {
        given().auth()
                .basic(getProperties().getProperty("secretKey"), "")
                .when()
                .get(getProperties().getProperty("EndPoint"))
                .then()
                .log().ifError()
                .assertThat().statusCode(200)
                .body("data.name", containsInAnyOrder("Ajeet22", "Arvind Prajapati", "Ajeet", "Ajeet Vishwakarma", "Shaurab Bind", "pradeep nisad", "Arvind Kumar","Ajeet22"));
    }
}

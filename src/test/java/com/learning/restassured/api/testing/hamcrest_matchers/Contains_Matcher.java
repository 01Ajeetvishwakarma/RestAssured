package com.learning.restassured.api.testing.hamcrest_matchers;

import com.learning.restassured.api.testing.common.Customer_Base_Test;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;

public class Contains_Matcher extends Customer_Base_Test {

    @Test
  public void   containsMatcherTest()
    {
        given().auth()
                .basic(getProperties().getProperty("secretKey"),"")
                .when()
                .get(getProperties().getProperty("EndPoint"))
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .body("data.name", contains("Ajeet22","Ajeet22", "Ajeet", "Arvind Prajapati", "Ajeet Vishwakarma", "Shaurab Bind", "pradeep nisad", "Arvind Kumar"));
    }

}

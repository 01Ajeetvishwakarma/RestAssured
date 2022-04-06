package com.learning.restassured.api.testing.hamcrest_matchers;


import com.learning.restassured.api.testing.common.Customer_Base_Test;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
public class Assert_Response_Body_BY_Hamcrest_Matchers extends Customer_Base_Test {

    @Test
    public void assertGetRequestWithResponseBody()
    {
        given().auth()
                .basic(getProperties().getProperty("secretKey"), "")
                .when()
                .get(getProperties().getProperty("EndPoint"))
                .then()
                .log().body()
                .assertThat().statusCode(200)
                .body("data.name", hasItems("Ajeet22", "Ajeet", "Arvind Prajapati", "Ajeet Vishwakarma", "Shaurab Bind", "pradeep nisad", "Arvind Kumar"))
                .body("data[0].name",equalToObject("Ajeet22"))
                .body("data[1].name",equalToObject("Ajeet"))
                .body("data[2].name",equalToObject("Arvind Prajapati"))
                .body("data[3].name",equalToObject("Ajeet Vishwakarma"));
    }

}

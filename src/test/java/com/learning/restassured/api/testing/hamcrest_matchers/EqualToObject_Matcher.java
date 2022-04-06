package com.learning.restassured.api.testing.hamcrest_matchers;

import com.learning.restassured.api.testing.common.Customer_Base_Test;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalToObject;

public class EqualToObject_Matcher extends Customer_Base_Test {

    @Test
   public void equalToObjectMethod()
   {
       given().auth()
               .basic(getProperties().getProperty("secretKey"), "")
               .when()
               .get(getProperties().getProperty("EndPoint"))
               .then()
               .log().all()
               .assertThat().statusCode(200)
               .body("data[0].name",equalToObject("Ajeet22"))
               .body("data[1].name",equalToObject("Ajeet"))
               .body("data[2].name",equalToObject("Arvind Prajapati"))
               .body("data[3].name",equalToObject("Ajeet Vishwakarma"))
               .body("data[4].name",equalToObject("Shaurab Bind"))
               .body("data[5].name",equalToObject("pradeep nisad"))
               .body("data[6].name",equalToObject("Arvind Kumar"));
   }

}

package com.learning.restassured.api.testing.automate_get_request;
import com.learning.restassured.api.testing.common.Customer_Base_Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class Assert_Status_Code extends Customer_Base_Test {

    @BeforeClass
    private void setUp()
    {
        requestSpecification = given()
                .auth()
                .basic(getProperties().getProperty("secretKey"), "");
    }


    @Test
    public void validate_response_code_from_get_request()
    {
         given()
                .auth().basic(getProperties().getProperty("secretKey"), "")
                .when()
                .get(getProperties().getProperty("EndPoint"))
                .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    @Test  //BDD => Business Driven Development
    public void validate_response_code_from_get_request_for_individual_customer()
    {
                 given(requestSpecification)
                .when()
                .get("https://api.stripe.com/v1/customers/cus_KqtqrFR4Gfdv6c")
                .then()
                .log().ifValidationFails()
                .assertThat().statusCode(200);
    }
}
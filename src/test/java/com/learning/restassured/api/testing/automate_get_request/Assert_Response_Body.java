package com.learning.restassured.api.testing.automate_get_request;

import com.learning.restassured.api.testing.common.Customer_Base_Test;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class Assert_Response_Body extends Customer_Base_Test {

    @Test
    public void validate_response_code_from_get_request_for_individual_customer()
    {
        given()
                .auth().basic(getProperties().getProperty("secretKey"), "")
                .when()
                .get("https://api.stripe.com/v1/customers/cus_KqtqrFR4Gfdv6c")
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .body("preferred_locales[0]",equalToObject("south"));
    }

}

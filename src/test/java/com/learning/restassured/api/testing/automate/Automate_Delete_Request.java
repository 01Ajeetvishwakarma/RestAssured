package com.learning.restassured.api.testing.automate;

import com.learning.restassured.api.testing.common.Customer_Base_Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Automate_Delete_Request  {

    @BeforeClass
    private void setUp()
        {
            RestAssured.requestSpecification = given()
                    .log().all()
                    .contentType(ContentType.JSON)
                    .baseUri("http://localhost:8080")
                    .basePath("/bookService");

            RestAssured.responseSpecification = RestAssured.expect().statusCode(200)
                    .contentType(ContentType.JSON).log().all();
        }

    @Test
    public void automate_Patch_Request()
        {
            given().contentType(ContentType.JSON)
            .pathParam("id",7)
            .delete("/book/{id}");
        }

}

package com.learning.restassured.api.testing.parameterization_through_dataprovider;


import com.learning.restassured.api.testing.common.Customer_Base_Test;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Create_Customer_Through_Data_Provider_By_Excel extends Customer_Base_Test {


    @Test(dataProvider = "get_Customer_Data_By_Excel_File")
    public void create_Customer_By_Excel_Data(String name, String email, String description)
    {
             Response response = given()
             .auth()
             .basic(getProperties().getProperty("secretKey"), "")
             .formParam("name",name)
              .formParam("email",email)
              .formParam("description",description)
              .post(getProperties().getProperty("EndPoint"));

           // assertThat(response.path("name"), equalTo(name));

            response.prettyPrint();
    }

}

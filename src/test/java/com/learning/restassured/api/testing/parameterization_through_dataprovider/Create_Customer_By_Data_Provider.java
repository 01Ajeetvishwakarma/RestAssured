package com.learning.restassured.api.testing.parameterization_through_dataprovider;

import com.learning.restassured.api.testing.common.Customer_Base_Test;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class Create_Customer_By_Data_Provider extends Customer_Base_Test {

//    @DataProvider
//    public Object[][] getCustomerData()
//    {
//        Object[][] data = new Object[2][3];
//
//        data[0][0] = "Ajeet2";
//        data[0][1] = "2@2.com";
//        data[0][2] = "gdfgdf";
//
//        data[1][0] = "Ajeet3";
//        data[1][1] = "3@3.com";
//        data[1][2] = "gdfgdf";
//
//        return data;
//    }


    @Test(dataProvider = "getCustomerData")
    public void createCustomerByDataProvider(String name, String email, String description)
    {
        Response response = given()
                .auth()
                .basic(getProperties().getProperty("secretKey"), "")
                .formParam("name",name)
                .formParam("email",email)
                .formParam("description",description)
                .post(getProperties().getProperty("EndPoint"));

        response.prettyPrint();
    }

}

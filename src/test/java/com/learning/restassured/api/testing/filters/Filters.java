//package com.learning.restassured.api.testing.filters;
//
//import io.restassured.filter.log.RequestLoggingFilter;
//import io.restassured.filter.log.ResponseLoggingFilter;
//import io.restassured.specification.RequestSpecification;
//import io.restassured.specification.ResponseSpecification;
//import org.testng.annotations.Test;
//
//import java.io.FileNotFoundException;
//import java.io.PrintStream;
//
//import static io.restassured.RestAssured.given;
//
//public class Filters {
//
//        RequestSpecification requestSpecification;
//        ResponseSpecification responseSpecification;
//
//     @Test
//     public void setup() throws FileNotFoundException {
//         PrintStream fileOutputAStream = new PrintStream("RestAssured.log");
//     }
//
//    @Test
//    public void logging_Filter()
//        {
//            given().baseUri("https://postman-echo.com")
//                    //.log().all()
//                    .filter(new RequestLoggingFilter())
//                    .filter(new ResponseLoggingFilter())
//                    .when()
//                    .get("/get")
//                    .then()
//                    //.log().all()
//                    .assertThat().statusCode(200);
//        }
//
//}

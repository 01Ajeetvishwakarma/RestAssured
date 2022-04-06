package com.learning.restassured.api.testing.request_parameters;

import org.testng.annotations.*;

import java.io.File;

import static io.restassured.RestAssured.given;

public class Upload_File_For_Multipart_Data {

    @Test
    public void upload_Multipart_Data_From_File()
    {
        String data = "{\"name\":\"multi_data.txt\",\"parent\":{\"id\":\"12\"}}";

        given().baseUri("https://postman-echo.com")
                .multiPart("file",new File("src/test/resources/multi_data.txt"))
                .multiPart("data", data,"application/json")
                .log().all()
                .when().post("/post")
                .then().log().all()
                .assertThat().statusCode(200);
    }

}

package com.learning.restassured.api.testing.request_parameters;

import org.testng.annotations.Test;

import java.io.*;

import static io.restassured.RestAssured.given;

public class Download_File {

    @Test
    public void download_File() throws IOException {
        //https://github.com/appium/appium/raw/master/sample-code/apps/ApiDemos-debug.apk
        //https://raw.githubusercontent.com/appium/appium/master/sample-code/apps/ApiDemos-debug.apk

      InputStream inputStream = given().baseUri("https://raw.githubusercontent.com")
                .log().all()
                .when()
                .get("/appium/appium/master/sample-code/apps/ApiDemos-debug.apk")
                .then()
                .log().all()
                .extract().response().asInputStream();

        OutputStream outputStream = new FileOutputStream(new File("src/test/resources/download_apk.apk"));

        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        outputStream.write(bytes);
        outputStream.close();
    }

}

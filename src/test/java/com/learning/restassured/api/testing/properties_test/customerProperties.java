package com.learning.restassured.api.testing.properties_test;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class customerProperties
{
    public static void main(String[] args) throws IOException
    {
        Properties properties = new Properties();

        FileInputStream fileInputStream = new FileInputStream("src/test/resources/customerProperties.properties");
        properties.load(fileInputStream);

        System.out.println("baseRUI: "+properties.getProperty("baseURI"));
        System.out.println("basePath: "+properties.getProperty("basePath"));
        System.out.println("customerEndPoint: "+properties.getProperty("customerEndPoint"));
        System.out.println("secretKey: "+properties.getProperty("secretKey"));
    }
}

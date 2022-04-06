package com.learning.restassured.api.testing.common;

import com.learning.restassured.api.testing.util.ExcelReader;
import io.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Customer_Base_Test {

    private ExcelReader excelReader;
    private Properties properties;

    @BeforeSuite
    public void setUP() throws IOException
    {
        properties = new Properties();

        FileInputStream fileInputStream = new FileInputStream("src/test/resources/customerProperties.properties");
        properties.load(fileInputStream);

        RestAssured.baseURI = properties.getProperty("baseURI");
        RestAssured.basePath = properties.getProperty("basePath");

        excelReader = new ExcelReader("src/test/resources/excel/exceldata.xlsx");

    }

    public Properties getProperties()
    {
        return properties;
    }

    @AfterSuite
    public void close()
    {

    }


    @DataProvider
    public Object[][] getCustomerData()
        {
            Object[][] data = new Object[2][3];

            data[0][0] = "Ajeet2";
            data[0][1] = "2@2.com";
            data[0][2] = "gdfgdf";

            data[1][0] = "Ajeet3";
            data[1][1] = "3@3.com";
            data[1][2] = "gdfgdf";

            return data;
        }



    @DataProvider
    public  Object[][] get_Customer_Data_By_Excel_File()
        {
            String sheetName = "customerData";
            int rows = excelReader.getRowCount(sheetName);
            int columns = excelReader.getColumnCount(sheetName);

    //        System.out.println(rows);
    //        System.out.println(columns);

            Object[][] data = new Object[rows-1][columns];

            for (int row=2; row<=rows; row++)
                {
                    for (int column=0; column<columns; column++)
                        {
                            data[row-2][column] = excelReader.getCellData(sheetName, column, row);
                        }
                }

            return  data;
        }

}

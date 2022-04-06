package com.learning.restassured.api.testing.common;

import com.learning.restassured.api.testing.util.ExcelReader;
import org.testng.annotations.DataProvider;

public class Base_Test {

    private ExcelReader excelReader;

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

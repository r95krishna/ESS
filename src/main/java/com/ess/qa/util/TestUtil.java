package com.ess.qa.util;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil {

    static public long page_load_time = 50;
    static public long implicit_wait = 50;

    static String TEST_DATA_FILE = "C:\\Users\\RAhul Krishna\\IdeaProjects\\Ess_Test\\src\\main\\java" +
            "\\com\\ess\\qa\\testdata\\Book.xlsx";

    static Workbook book;
    static Sheet sheet;

    public static Object[][] GetTestData(String sheetName) {

        FileInputStream file = null;
        try {

            file = new FileInputStream(TEST_DATA_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            book = WorkbookFactory.create(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getFirstCellNum()];
        System.out.println(sheet.getLastRowNum());
        System.out.println(sheet.getRow(0).getLastCellNum());
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            for (int j = 0; j <= sheet.getRow(0).getLastCellNum(); j++) {

                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
            }
        }
        return data;
    }


}


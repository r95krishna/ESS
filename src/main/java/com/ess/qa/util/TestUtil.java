package com.ess.qa.util;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil {

    static public long page_load_time=50;
    static public long implicit_wait=50;

    static  String TEST_DATA_FILE="";

    static Workbook book;
    static Sheet sheet;
    public static void GetTestData(String sheetName){

        FileInputStream file=null;
        try{
            file=new FileInputStream(TEST_DATA_FILE);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

        try{
            book=WorkbookFactory.create(file);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        sheet=book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

    }


}

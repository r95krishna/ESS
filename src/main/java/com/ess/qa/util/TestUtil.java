package com.ess.qa.util;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import static com.ess.qa.base.TestBase.driver;

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


    public static void TakeScreenshot() throws IOException {

        Date d= new Date();
        String date= d.toString();

        System.out.println("date of screenshot:"+date);

        TakesScreenshot ts= (TakesScreenshot)driver;

        File srcFile= ts.getScreenshotAs(OutputType.FILE);

        File desiredfile= new File("C:\\Users\\Rahul Krishna\\IdeaProjects\\ESS\\screenshot\\__actiTIMELoginPage.png");

        FileUtils.copyFile(srcFile, desiredfile);


    }


}

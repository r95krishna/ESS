package com.ess.qa.pages;

import org.apache.poi.hssf.util.PaneInformation;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

public class learning {

    public Object[][] getTestData(String SheetName) throws IOException, InvalidFormatException {

        String path = "C:\\Users\\RAhul Krishna\\IdeaProjects\\excel file\\Book.xlsx";
        FileInputStream file = new FileInputStream("path");
        Workbook book = WorkbookFactory.create(file);

        Sheet sheet = book.getSheet(SheetName);

        Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getFirstCellNum()];
        System.out.println(sheet.getLastRowNum());
        System.out.println(sheet.getRow(0).getLastCellNum());
        for(int i=0;i<=sheet.getLastRowNum();i++){
            for(int j=0;j<=sheet.getRow(0).getLastCellNum();j++){

                data[i][j]=sheet.getRow(i+1).getCell(j).toString();
            }
        }
        return data;
    }




}

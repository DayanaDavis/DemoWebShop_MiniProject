package com.demowebshop.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcelUtility {
    public String readSingleData(int i, int j, String filepath,String sheetname) throws IOException {
        FileInputStream inputStream = new FileInputStream(filepath);
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = wb.getSheet(sheetname);
        Row r = sheet.getRow(i);
        Cell c = r.getCell(j);
        DataFormatter formatter = new DataFormatter();
        String value = formatter.formatCellValue(sheet.getRow(i).getCell(j));
        return value;
    }
    public Object[][] readDataFromExcel(String filePath, String sheetName) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int noOfRows = sheet.getLastRowNum();
        int noOfColumns = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[noOfRows][noOfColumns];
        for (int i = 1; i <=noOfRows; i++) {
            for (int j = 0; j < noOfColumns; j++) {
                DataFormatter formatter = new DataFormatter();
                data[i-1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
            }
            System.out.println();
        }
        workbook.close();
        file.close();
        return data;
    }
}

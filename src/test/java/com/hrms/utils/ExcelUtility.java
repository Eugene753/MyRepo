package com.hrms.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtility {

    public static Workbook book;
    public static Sheet sheet;

    public static void openExcel(String filePath){
        try {
            FileInputStream fis=new FileInputStream(filePath);
            book=new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     *
     *
     * @param sheetName
     */
    public static void getSheet(String sheetName){

        sheet=book.getSheet(sheetName);
    }

    public static int getRowsCount(){
        return sheet.getPhysicalNumberOfRows();
    }

    public static int getColsCount(int rowNum){
        return sheet.getRow(rowNum).getPhysicalNumberOfCells();
    }

    public static String getData(int row,int col){
        return sheet.getRow(row).getCell(col).toString();
    }


    public static List<Map<String,String>> excelDataToList(String filePath,String sheetName){
        openExcel(filePath);
        getSheet(sheetName);

        List<Map<String, String>> dataList=new ArrayList<>();
        Map<String,String> dataMap;

        for(int r=1;r<getRowsCount();r++){
            dataMap=new LinkedHashMap<>();
            for(int c=0;c<getColsCount(r);c++){
                dataMap.put(getData(0,c),getData(r,c));
            }
            dataList.add(dataMap);
        }
        return dataList;
    }

}

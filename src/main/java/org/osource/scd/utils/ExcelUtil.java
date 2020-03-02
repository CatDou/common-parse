package org.osource.scd.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author chengdu
 * @date 2019/6/27.
 */
public class ExcelUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelUtil.class);

    public static final String EXCEL_XLS = ".xls";
    public static final String EXCEL_XLSX = ".xlsx";

    /**
     * 创建 workbook
     * @param filePath
     * @return
     */
    public static Workbook createWorkBook(String filePath){
        if(filePath == null){
            throw new IllegalArgumentException("filePath is null");
        }
        Workbook workbook;
        if(filePath.endsWith(EXCEL_XLS)){
            workbook = new HSSFWorkbook();
        }else if(filePath.endsWith(EXCEL_XLSX)){
            workbook = new XSSFWorkbook();
//            workbook = new SXSSFWorkbook();
        }else{
            throw new IllegalArgumentException("excel type error");
        }
        return workbook;
    }

    public static Workbook getWorkBook(String filePath){
        if(filePath == null){
            throw new IllegalArgumentException("filePath is null");
        }
        InputStream inputStream = null;
        Workbook workbook = null;
        try {
            inputStream = new FileInputStream(filePath);
            if(filePath.endsWith(EXCEL_XLS)){
                workbook = new HSSFWorkbook(inputStream);
            }else if(filePath.endsWith(EXCEL_XLSX)){
                workbook = new XSSFWorkbook(inputStream);
            }else{
                throw new IllegalArgumentException("excel type error");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return workbook;
    }

    public static void main(String[] args)  {
//        String filePath = "C:\\Users\\chengdu\\Desktop\\12345中文.xlsx";
//        Workbook workbook = getWorkBook(filePath);
//        Sheet sheet = workbook.getSheetAt(0);
//        int rows = sheet.getPhysicalNumberOfRows();
//        for (int i = 0; i < rows; i++) {
//            Row row = sheet.getRow(i);
//            row.getPhysicalNumberOfCells();
//            row.getCell(1).setCellType(CellType.STRING);
//            String value = row.getCell(1).getStringCellValue();
//            System.out.println(value);
//        }
    }
}

package org.osource.scd.utils;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @author chengdu
 *
 */
public class ExcelUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelUtil.class);

    public static final String EXCEL_XLS = ".xls";
    public static final String EXCEL_XLSX = ".xlsx";

    /**
     * 创建 workbook
     * @param filePath file path
     * @return Workbook
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

    public static String getCellValue(Row row, Integer column) {
        Cell cell = row.getCell(column);
        String cellValue = "";
        switch (cell.getCellType()) {
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    Date date = cell.getDateCellValue();
                    // 转换为 long 时间
                    cellValue = "L" + date.getTime();
                } else {
                    cellValue = String.valueOf(cell.getNumericCellValue());
                }
                break;
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA:
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case BLANK:
                break;
            default:
                break;
        }
        return cellValue;
    }
}

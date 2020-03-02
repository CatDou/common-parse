package org.osource.scd.parse.format;

/**
 * @author chengdu
 * @date 2020/1/17
 */
public interface CellFormat {
    String format(String column, String cellValue);
}

package org.osource.scd.parse.define;


import org.osource.scd.parse.format.CellFormat;

/**
 * @author chengdu
 * @date 2020/1/17
 */
public class InfoFormat implements CellFormat {

    @Override
    public String format(String column, String cellValue) {
        if ("B".equals(column)) {
            if (cellValue != null && cellValue.length() > 1) {
                cellValue =cellValue.substring(0, cellValue.length() - 1);
            }
        }
        return cellValue;
    }
}

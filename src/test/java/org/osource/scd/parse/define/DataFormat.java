package org.osource.scd.parse.define;

import org.osource.scd.utils.DateUtil;

import java.util.Date;

/**
 * @author James
 */
public class DataFormat implements CellFormat {

    @Override
    public String format(String column, String cellValue) {
        if ("E".equals(column)) {
            Date date = DateUtil.parseStrToDate(cellValue, "YYYY年MM月dd日HH时mm分");
            return "L" + date.getTime();
        }
        return cellValue;
    }
}

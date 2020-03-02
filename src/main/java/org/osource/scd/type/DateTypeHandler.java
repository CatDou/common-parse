package org.osource.scd.type;


import org.osource.scd.utils.DateUtil;

import java.util.Date;

/**
 * @author chengdu
 * @date 2019/8/30.
 */
public class DateTypeHandler implements BaseTypeHandler {
    @Override
    public Object convertStrToType(String input) {
        if (input.startsWith("L")) {
            long longDate = Long.valueOf(input.substring(1).trim());
            return new Date(longDate);
        }
        return DateUtil.parseStrToDate(input);
    }
}

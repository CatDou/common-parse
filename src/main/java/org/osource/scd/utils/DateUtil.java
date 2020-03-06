package org.osource.scd.utils;

import org.osource.scd.exception.DataParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author chengdu
 *
 */
public class DateUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);

    private static final Map<Pattern, String> REGEX_MAP;
    static {
        Map<Pattern, String> map = new HashMap();
        map.put(Pattern.compile("\\d{4}/\\d{1,2}/\\d{1,2}"), "yyyy/MM/dd");
        map.put(Pattern.compile("\\d{4}-\\d{1,2}-\\d{1,2}"), "yyyy-MM-dd");
        map.put(Pattern.compile("\\d{4}-\\d{1,2}-\\d{1,2}\\s{1,2}\\d{2}:\\d{2}:\\d{2}"), "yyyy-MM-dd HH:mm:ss");
        map.put(Pattern.compile("\\d{4}-\\d{1,2}-\\d{1,2}\\s{1,2}\\d{2}:\\d{2}"), "yyyy-MM-dd HH:mm");
        map.put(Pattern.compile("\\d{4}\\.\\d{1,2}\\.\\d{1,2}"), "yyyy.MM.dd");
        map.put(Pattern.compile("\\d{4}/\\d{1,2}/\\d{1,2}\\s{1,2}\\d{2}:\\d{2}:\\d{2}"), "yyyy/MM/dd HH:mm:ss");
        map.put(Pattern.compile("\\d{4}/\\d{1,2}/\\d{1,2}\\s{1,2}\\d{2}:\\d{2}"), "yyyy/MM/dd HH:mm");
        REGEX_MAP = Collections.unmodifiableMap(map);
    }

    public static Date parseStrToDate(String dateStr){
        String pattern = null;
        Set<Map.Entry<Pattern,String>> entrySet = REGEX_MAP.entrySet();
        for (Map.Entry<Pattern, String> entry : entrySet){
            if (entry.getKey().matcher(dateStr).matches()){
                pattern = entry.getValue();
                break;
            }
        }
        if (pattern == null){
            LOGGER.error("pattern not config or input str error {}", dateStr);
            throw new DataParseException("pattern not config or input str error " + dateStr);
        }
        return parseStrToDate(dateStr, pattern);
    }

    public static Date parseStrToDate(String dateStr, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}

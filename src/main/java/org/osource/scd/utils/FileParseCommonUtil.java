package org.osource.scd.utils;

import org.osource.scd.constant.CommonConstant;
import org.osource.scd.constant.ParseType;
import org.osource.scd.exception.FileParseException;
import org.osource.scd.param.ParseParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author chengdu
 *
 */
public class FileParseCommonUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileParseCommonUtil.class);

    public static Map<String, Method> convertToColumnMethodMap(Class<?> clazz, Map<String, String>  fieldColumnMap) {
        Set<Map.Entry<String, String>> entrySet = fieldColumnMap.entrySet();
        Map<String, Method> columnFieldSetter = new HashMap<>(16);
        Map<String, Method> allBeanSetter = ReflectUtil.getBeanSetterMap(clazz);
        for (Map.Entry<String, String> entry : entrySet) {
            String column = entry.getKey();
            String fieldName = entry.getValue().toLowerCase();
            Method setterMethod = allBeanSetter.get(fieldName);
            if (setterMethod == null) {
                throw new IllegalArgumentException("Bean " + clazz + " not contain field " + fieldName +
                        " ,please check config column map");
            }
            columnFieldSetter.put(column, allBeanSetter.get(fieldName));
        }
        return columnFieldSetter;
    }

    public static <T> void invokeValue( T t, Method method, String value) {
        if (StringUtils.isEmpty(value)) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("input value is empty");
            }
            return;
        }
        if (method == null) {
            throw new IllegalArgumentException("input set method is null");
        }
        if (method.getParameterTypes().length != 1) {
            LOGGER.error("input method parameter type error");
            return;
        }
        if (!method.getName().startsWith("set")) {
            LOGGER.error("input method not setter method {}", method.getName());
            return;
        }
        String typeName = method.getParameterTypes()[0].getTypeName();
        if (!CommonConstant.HANDLER_MAP.containsKey(typeName)) {
            LOGGER.error("unknown type handler {}", typeName);
            return ;
        }
        Object typeValue = CommonConstant.HANDLER_MAP.get(typeName).convertStrToType(value);
        try {
            method.invoke(t, typeValue);
        } catch (Exception e) {
            throw new FileParseException("invoke value error", e);
        }
    }

    public static ParseType findParserType(String filePath) {
        if (StringUtils.isEmpty(filePath)) {
            throw new IllegalArgumentException("input filepath is empty");
        }
        ParseType parseType;
        if (filePath.endsWith(".csv")) {
            parseType = ParseType.CSV;
        } else if (filePath.endsWith(".xls")|| filePath.endsWith(".xlsx")) {
            parseType = ParseType.EXCEL;
        } else {
            throw new IllegalArgumentException("input filepath error " + filePath);
        }
        return parseType;
    }

    public static ParseType findParserType(String filePath, ParseParam parseParam) {
        ParseType parseTypeFind = findParserType(filePath);
        // 如果参数 说明要 EasyExcel 解析就使用 Easy Excel
        if (ParseType.EXCEL.name().equals(parseTypeFind.name())
                && parseParam.getParseType() != null) {
            if (ParseType.EASYEXCEL.name().equals(parseParam.getParseType().name())) {
                return ParseType.EASYEXCEL;
            }
        }
        return parseTypeFind;
    }


    public static char[] UPPER_CHAR = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S',
            'T','U','V','W','X','Y','Z'};

    /**
     * 从 0 开始, AAA-702 不考虑
     * @param num the char num
     * @return excel column str
     */
    public static String calExcelNumChar(int num) {
        if (num < 0 || num >= 702) {
            throw new IllegalArgumentException("column num input error");
        }
        if (num < 26) {
            return String.valueOf(UPPER_CHAR[num]);
        }
        int firstIndex = num / 26 - 1;
        int secondIndex = num % 26;
        return String.valueOf(UPPER_CHAR[firstIndex]) + UPPER_CHAR[secondIndex];
    }

    public static Map<String, Integer> EXCEL_COLUMN = new HashMap<>();

    public static Map<Integer, String> COLUMN_NUM = new HashMap<>();

    static {
        for (int i = 0; i < 702; i++) {
            String columnStr = calExcelNumChar(i);
            EXCEL_COLUMN.put(columnStr, i);
            COLUMN_NUM.put(i, columnStr);
        }
    }
}

package org.osource.scd.parse;


import org.osource.scd.param.ParseParam;
import org.osource.scd.parse.model.ExcelTypeVo;
import org.osource.scd.parse.model.ReflectVo;
import org.osource.scd.utils.FileParseCommonUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chengdu
 * @date 2020/1/12
 */
public class ParseCommonTest {

    public ParseParam createReflectParam() {
        Map<String, String> fieldColumnMap = new HashMap<>(16);
        fieldColumnMap.put("A", "id");
        fieldColumnMap.put("B", "userName");
        fieldColumnMap.put("C", "score");
        fieldColumnMap.put("D", "date");
        Map<String, Method> columnMethodMap = FileParseCommonUtil.convertToColumnMethodMap(ReflectVo.class, fieldColumnMap);
        ParseParam parseParam = new ParseParam().setStartLine(1)
                .setFieldSetterMap(columnMethodMap);
        return parseParam;

    }

    public ParseParam createExcelTypeParam() {
        Map<String, String> fieldColumnMap = new HashMap<>(16);
        fieldColumnMap.put("A", "id");
        fieldColumnMap.put("B", "userName");
        fieldColumnMap.put("C", "score");
        fieldColumnMap.put("D", "date");
        fieldColumnMap.put("E", "numDate");
        fieldColumnMap.put("F", "bool");
        Map<String, Method> columnMethodMap = FileParseCommonUtil.convertToColumnMethodMap(ExcelTypeVo.class, fieldColumnMap);
        ParseParam parseParam = new ParseParam().setStartLine(1)
                .setFieldSetterMap(columnMethodMap);
        return parseParam;
    }
}

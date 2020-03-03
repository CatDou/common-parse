package org.osource.scd.parse;

import org.junit.Assert;
import org.junit.Test;
import org.osource.scd.constant.ParseType;
import org.osource.scd.param.ParseParam;
import org.osource.scd.parse.model.ExcelTypeVo;
import org.osource.scd.parse.model.MergeDataVo;
import org.osource.scd.parse.model.ReflectVo;
import org.osource.scd.utils.FileParseCommonUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chengdu
 *
 */
public class ExcelParseTest extends ParseCommonTest {

    @Test
    public void testExcel2003() {
        String filePath = "file/test2003.xls";
        FileParse fileParse = FileParseCreateor.createFileParse(FileParseCommonUtil.findParserType(filePath));
        List<ReflectVo> reflectVoList = fileParse.parseFile(filePath, ReflectVo.class, createReflectParam());
        Assert.assertEquals(6, reflectVoList.size());
    }

    @Test
    public void testExcel2007() {
        String filePath = "file/test2007.xlsx";
        FileParse fileParse = FileParseCreateor.createFileParse(FileParseCommonUtil.findParserType(filePath));
        List<ReflectVo> reflectVoList = fileParse.parseFile(filePath, ReflectVo.class, createReflectParam());
        Assert.assertEquals(6, reflectVoList.size());
    }

    @Test
    public void testExcelType() {
        String filePath = "file/data-type.xlsx";
        FileParse fileParse = FileParseCreateor.createFileParse(FileParseCommonUtil.findParserType(filePath));
        List<ExcelTypeVo> excelTypeVos = fileParse.parseFile(filePath, ExcelTypeVo.class, createExcelTypeParam());
        Assert.assertEquals(6, excelTypeVos.size());
    }

    @Test
    public void testColumn() {
        String name = "ZZ";
        int column = -1;
        char[] charArr = name.toCharArray();
        for (char c : charArr) {
            column = (column + 1) * 26 + c - 'A';
        }
        System.out.print(column);
//        column + 1 / 26
    }

    @Test
    public void testGenChar() {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < 26; i++) {
            char curChar = (char) ('A' + i);
            stringBuilder.append("\'").append(curChar).append("\'").append(",");
        }
        System.out.println(stringBuilder.toString());
    }

    @Test
    public void testColumnMap() {
        Assert.assertTrue(FileParseCommonUtil.EXCEL_COLUMN.get("A") == 0);
        Assert.assertTrue("A".equals(FileParseCommonUtil.COLUMN_NUM.get(0)));
    }

    @Test
    public void testManySheet() {
        String filePath = "file/many-sheet-data.xlsx";
        // sheet1 param
        Map<String, String> fieldColumnMap = new HashMap<>(16);
        fieldColumnMap.put("A", "string");
        fieldColumnMap.put("B", "date");
        fieldColumnMap.put("C", "doubleData");
        fieldColumnMap.put("D", "utDate");
        Map<String, Method> columnMethodMap = FileParseCommonUtil.convertToColumnMethodMap(MergeDataVo.class, fieldColumnMap);
        ParseParam sheet0Param = new ParseParam().setStartLine(1)
                .setFieldSetterMap(columnMethodMap);
        Map<String, String> fieldColumnMap2 = new HashMap<>(16);
        fieldColumnMap2.put("A", "id");
        fieldColumnMap2.put("B", "userName");
        fieldColumnMap2.put("C", "score");
        fieldColumnMap2.put("D", "rdate");
        Map<String, Method> columnMethodMap2 = FileParseCommonUtil.convertToColumnMethodMap(MergeDataVo.class, fieldColumnMap2);
        ParseParam sheet1Param = new ParseParam().setStartLine(1)
                .setFieldSetterMap(columnMethodMap2);
        Map<Integer, ParseParam> map = new HashMap<>(16);
        map.put(0, sheet0Param);
        map.put(1, sheet1Param);
        FileParse fileParse = FileParseCreateor.createFileParse(ParseType.EXCEL);
        Map<Integer, List<MergeDataVo>> resultMap = fileParse.parseFileSheets(filePath, MergeDataVo.class, map);
        System.out.println(resultMap);
    }

}

package org.osource.scd.parse;

import org.junit.Assert;
import org.junit.Test;
import org.osource.scd.constant.CommonConstant;
import org.osource.scd.constant.ParseType;
import org.osource.scd.param.ParseParam;
import org.osource.scd.parse.model.DemoData;
import org.osource.scd.parse.model.ExcelTypeVo;
import org.osource.scd.utils.FileParseCommonUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chengdu
 * @date 2020/3/1
 */
public class EasyExcelParseTest extends ParseCommonTest {

    @Test
    public void testParse() {
        String filePath = "file/demo.xlsx";
        ParseParam parseParam = createDemoParam();
        FileParse fileParse = FileParseCreateor.createFileParse(FileParseCommonUtil.findParserType(filePath, parseParam));
        List<DemoData> demoDataList = fileParse.parseFile(filePath, DemoData.class, parseParam);
        System.out.println(demoDataList);
    }

    @Test
    public void testParseDemoXls() {
        String filePath = "file/demo2003.xls";
        ParseParam parseParam = createDemoParam();
        FileParse fileParse = FileParseCreateor.createFileParse(FileParseCommonUtil.findParserType(filePath, parseParam));
        List<DemoData> demoDataList = fileParse.parseFile(filePath, DemoData.class, parseParam);
        System.out.println(demoDataList);
    }

    @Test
    public void testExcelType() {
        String filePath = "file/data-type.xlsx";
        ParseParam parseParam = createExcelTypeParam();
        parseParam.setParseType(ParseType.EASYEXCEL);
        FileParse fileParse = FileParseCreateor.createFileParse(FileParseCommonUtil.findParserType(filePath, parseParam));
        List<ExcelTypeVo> excelTypeVos = fileParse.parseFile(filePath, ExcelTypeVo.class, parseParam);
        Assert.assertEquals(6, excelTypeVos.size());
    }

    public ParseParam createDemoParam() {
        Map<String, String> fieldColumnMap = new HashMap<>(16);
        fieldColumnMap.put("A", "string");
        fieldColumnMap.put("B", "date");
        fieldColumnMap.put("C", "doubleData");
        fieldColumnMap.put("D", "utDate");
        Map<String, Method> columnMethodMap = FileParseCommonUtil.convertToColumnMethodMap(DemoData.class, fieldColumnMap);
        ParseParam parseParam = new ParseParam().setStartLine(1)
                .setFieldSetterMap(columnMethodMap).setParseType(ParseType.EASYEXCEL);
        return parseParam;
    }
}

package org.osource.scd.parse;

import org.junit.Assert;
import org.junit.Test;
import org.osource.scd.constant.ParseType;
import org.osource.scd.param.ParseParam;
import org.osource.scd.parse.model.MergeDataVo;
import org.osource.scd.parse.model.ReflectVo;
import org.osource.scd.utils.AnnotationUtil;
import org.osource.scd.utils.FileParseCommonUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class ExcelParseAnno {

    @Test
    public void testExcelAnno() {
        String filePath = "file/many-sheet-data.xlsx";
        Map<Integer, Map<String, Method>> sheetMethodMap = AnnotationUtil.findManySheetSetter(MergeDataVo.class);
        Assert.assertEquals(2, sheetMethodMap.size());
        ParseParam sheet0Param = new ParseParam().setStartLine(1)
                .setFieldSetterMap(sheetMethodMap.get(0));
        ParseParam sheet1Param = new ParseParam().setStartLine(1)
                .setFieldSetterMap(sheetMethodMap.get(1));
        Map<Integer, ParseParam> map = new HashMap<>(16);
        map.put(0, sheet0Param);
        map.put(1, sheet1Param);
        FileParse fileParse = FileParseCreateor.createFileParse(ParseType.EXCEL);
        Map<Integer, List<MergeDataVo>> resultMap = fileParse.parseFileSheets(filePath, MergeDataVo.class, map);
        System.out.println(resultMap);
    }

    @Test
    public void testEasyExcelAnno() {
        String filePath = "file/many-sheet-data.xlsx";
        Map<Integer, Map<String, Method>> sheetMethodMap = AnnotationUtil.findManySheetSetter(MergeDataVo.class);
        Assert.assertEquals(2, sheetMethodMap.size());
        ParseParam sheet0Param = new ParseParam().setStartLine(1)
                .setFieldSetterMap(sheetMethodMap.get(0));
        ParseParam sheet1Param = new ParseParam().setStartLine(1)
                .setFieldSetterMap(sheetMethodMap.get(1));
        Map<Integer, ParseParam> map = new HashMap<>(16);
        map.put(0, sheet0Param);
        map.put(1, sheet1Param);
        FileParse fileParse = FileParseCreateor.createFileParse(ParseType.EASYEXCEL);
        Map<Integer, List<MergeDataVo>> resultMap = fileParse.parseFileSheets(filePath, MergeDataVo.class, map);
        System.out.println(resultMap);
    }

    @Test
    public void testExcel2003() {
        String filePath = "file/test2003.xls";
        ParseParam parseParam = new ParseParam()
                .setFieldSetterMap(AnnotationUtil.findOneSheetSetter(ReflectVo.class))
                .setStartLine(1);
        FileParse fileParse = FileParseCreateor.createFileParse(FileParseCommonUtil.findParserType(filePath, parseParam));
        List<ReflectVo> reflectVoList = fileParse.parseFile(filePath, ReflectVo.class, parseParam);
        Assert.assertEquals(6, reflectVoList.size());
    }

    @Test
    public void testExcel2007() {
        String filePath = "file/test2007.xlsx";
        ParseParam parseParam = new ParseParam()
                .setFieldSetterMap(AnnotationUtil.findOneSheetSetter(ReflectVo.class))
                .setStartLine(1);
        FileParse fileParse = FileParseCreateor.createFileParse(FileParseCommonUtil.findParserType(filePath, parseParam));
        List<ReflectVo> reflectVoList = fileParse.parseFile(filePath, ReflectVo.class, parseParam);
        Assert.assertEquals(6, reflectVoList.size());
    }

    @Test
    public void testExcel2003EasyExcel() {
        String filePath = "file/test2003.xls";
        ParseParam parseParam = new ParseParam()
                .setFieldSetterMap(AnnotationUtil.findOneSheetSetter(ReflectVo.class))
                .setStartLine(1).setParseType(ParseType.EASYEXCEL);
        FileParse fileParse = FileParseCreateor.createFileParse(FileParseCommonUtil.findParserType(filePath, parseParam));
        List<ReflectVo> reflectVoList = fileParse.parseFile(filePath, ReflectVo.class, parseParam);
        Assert.assertEquals(6, reflectVoList.size());
    }

    @Test
    public void testExcel2007EasyExcel() {
        String filePath = "file/test2007.xlsx";
        ParseParam parseParam = new ParseParam()
                .setFieldSetterMap(AnnotationUtil.findOneSheetSetter(ReflectVo.class))
                .setStartLine(1).setParseType(ParseType.EASYEXCEL);
        FileParse fileParse = FileParseCreateor.createFileParse(FileParseCommonUtil.findParserType(filePath, parseParam));
        List<ReflectVo> reflectVoList = fileParse.parseFile(filePath, ReflectVo.class, parseParam);
        Assert.assertEquals(6, reflectVoList.size());
    }
}

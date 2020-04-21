package org.osource.scd.parse;

import org.junit.Assert;
import org.junit.Test;
import org.osource.scd.constant.ParseType;
import org.osource.scd.param.ParseParam;
import org.osource.scd.parse.define.DataFormat;
import org.osource.scd.parse.model.DataFormatVo;
import org.osource.scd.utils.AnnotationUtil;
import org.osource.scd.utils.FileParseCommonUtil;

import java.util.List;

/**
 * @author James
 */
public class DefineCellFormatTest {

    public List<DataFormatVo> parseFileToDataFomatVo(String filePath, boolean isEasyExcel) {
        ParseParam parseParam = new ParseParam()
                .setSheetNum(0).setStartLine(1)
                .setFieldSetterMap(AnnotationUtil.findOneSheetSetter(DataFormatVo.class))
                .setCellFormat(new DataFormat());
        if (isEasyExcel) {
            parseParam.setParseType(ParseType.EASYEXCEL);
        }
        FileParse fileParse = FileParseCreateor.createFileParse(FileParseCommonUtil.findParserType(filePath, parseParam));
        return fileParse.parseFile(filePath, DataFormatVo.class, parseParam);
    }

    @Test
    public void testCsv() {
        String filePath = "file/cn-time.csv";
        List<DataFormatVo> dataFormatVos = parseFileToDataFomatVo(filePath, false);
        Assert.assertTrue(dataFormatVos.size() > 0);
    }

    @Test
    public void testExcelFormat() {
        String filePath = "file/cn-time.xlsx";
        List<DataFormatVo> dataFormatVos = parseFileToDataFomatVo(filePath, false);
        Assert.assertTrue(dataFormatVos.size() > 0);
    }

    @Test
    public void testEasyExcelFormat() {
        String filePath = "file/cn-time.xlsx";
        List<DataFormatVo> dataFormatVos = parseFileToDataFomatVo(filePath, true);
        Assert.assertTrue(dataFormatVos.size() > 0);
    }
}

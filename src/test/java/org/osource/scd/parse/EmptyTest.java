package org.osource.scd.parse;

import org.junit.Assert;
import org.junit.Test;
import org.osource.scd.constant.ParseType;
import org.osource.scd.param.ParseParam;
import org.osource.scd.parse.model.Label;
import org.osource.scd.utils.AnnotationUtil;
import org.osource.scd.utils.FileParseCommonUtil;

import java.util.List;

/**
 * @author James
 */
public class EmptyTest {

    @Test
    public void testCellEmpty() {
        String excelPath = "file/test-empty.xlsx";
        ParseParam parseParam = new ParseParam()
                .setStartLine(1)
                .setFieldSetterMap(AnnotationUtil.findOneSheetSetter(Label.class))
                .setParseType(ParseType.EASYEXCEL);
        FileParse fileParse = FileParseCreateor.createFileParse(
                FileParseCommonUtil.findParserType(excelPath, parseParam));
        List<Label> labelList = fileParse.parseFile(excelPath, Label.class, parseParam);
        Assert.assertTrue(labelList.size() > 0);
    }
}

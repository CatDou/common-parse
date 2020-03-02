package org.osource.scd.parse;

import com.alibaba.excel.EasyExcel;
import org.osource.scd.param.ParseParam;
import org.osource.scd.parse.event.ModelParserListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author chengdu
 * @date 2020/2/29
 */
public class EasyExcelParse implements FileParse {
    private static final Logger LOGGER = LoggerFactory.getLogger(EasyExcelParse.class);

    @Override
    public <T> List<T> parseFile(String filePath, Class<T> clazz, ParseParam parseParam) {
        List<T> resultList = new LinkedList<>();
        ModelParserListener modelParserListener = new ModelParserListener(parseParam, resultList, clazz);
        EasyExcel.read(filePath, modelParserListener).useDefaultListener(false)
                .sheet(parseParam.getSheetNum()).headRowNumber(parseParam.getStartLine()).doRead();
        return resultList;
    }

    @Override
    public <T> Map<Integer, List<T>> parseFileSheets(String filePath, Class<T> clazz, Map<Integer, ParseParam> parseParamMap) {
        return null;
    }

}

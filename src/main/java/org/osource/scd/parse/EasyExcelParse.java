package org.osource.scd.parse;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import org.osource.scd.exception.FileParseException;
import org.osource.scd.param.ParseParam;
import org.osource.scd.parse.event.ModelManySheetParserListener;
import org.osource.scd.parse.event.ModelParserListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author chengdu
 *
 */
public class EasyExcelParse implements FileParse {
    private static final Logger LOGGER = LoggerFactory.getLogger(EasyExcelParse.class);

    @Override
    public <T> List<T> parseFile(String filePath, Class<T> clazz, ParseParam parseParam) {
        List<T> resultList = new ArrayList<>();
        ModelParserListener modelParserListener = new ModelParserListener(parseParam, resultList, clazz);
        EasyExcel.read(filePath, modelParserListener).useDefaultListener(false)
                .sheet(parseParam.getSheetNum()).headRowNumber(parseParam.getStartLine()).doRead();
        return resultList;
    }

    @Override
    public <T> Map<Integer, List<T>> parseFileSheets(String filePath, Class<T> clazz, Map<Integer, ParseParam> parseParamMap) {
        Map<Integer, List<T>> resultMap = new HashMap<>(16);
        ModelManySheetParserListener modelParserListener = new ModelManySheetParserListener(parseParamMap, resultMap, clazz);
        ExcelReader excelReader = null;
        try {
            excelReader = EasyExcel.read(filePath).build();
            Set<Integer> sheetSet = parseParamMap.keySet();
            ReadSheet[] readSheetArrays = new ReadSheet[sheetSet.size()];
            for (Integer sheet : sheetSet) {
                ReadSheet readSheet = EasyExcel.readSheet(sheet).registerReadListener(modelParserListener).build();
                readSheetArrays[sheet] = readSheet;
            }
            excelReader.read(readSheetArrays);
        } catch (Exception e) {
            LOGGER.error("read excel error");
            throw new FileParseException("read excel error",e);
        } finally {
            if (excelReader != null) {
                excelReader.finish();
            }
        }
        return resultMap;
    }
}

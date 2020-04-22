package org.osource.scd.parse.event;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.read.metadata.holder.ReadHolder;
import com.alibaba.excel.util.ConverterUtils;
import org.osource.scd.param.ParseParam;
import org.osource.scd.utils.FileParseCommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author chengdu
 *
 */
public class ModelParserCommon {
    private static final Logger LOGGER = LoggerFactory.getLogger(ModelParserCommon.class);

    public static <T> T convertCellDataMapToVo(Map<Integer, CellData> cellDataMap, AnalysisContext analysisContext,
                                               Class<T> clazz, ParseParam parseParam) {
        T t = null;
        try {
            t = clazz.newInstance();
            ReadHolder currentReadHolder = analysisContext.currentReadHolder();
            Map<String, Method> fieldSetterMap = parseParam.getFieldSetterMap();
            for (Map.Entry<String, Method> entry : fieldSetterMap.entrySet()) {
                String columnChar = entry.getKey();
                Integer column = FileParseCommonUtil.EXCEL_COLUMN.get(columnChar);
                Object cellData = cellDataMap.get(column);
                if (cellData == null) {
                    LOGGER.error("column char parse no data {}", columnChar);
                    int rowIndex = analysisContext.readRowHolder().getRowIndex();
                    parseParam.getErrorRecord().writeErrorMsg("line " + rowIndex + ":" +
                            column + "column char parse no data");
                    continue;
                }
                String cellValue;
                if (cellData instanceof CellData) {
                    CellData convertCellData = (CellData) cellData;
                    // Converter not found, convert EMPTY to java.lang.String
                    if (CellDataTypeEnum.EMPTY == convertCellData.getType()) {
                        continue;
                    }
                    cellValue = (String) ConverterUtils.convertToJavaObject(convertCellData, null, null,
                            currentReadHolder.converterMap(),
                            currentReadHolder.globalConfiguration(), analysisContext.readRowHolder().getRowIndex(), column);
                } else if (cellData instanceof String) {
                    cellValue = (String) cellData;
                } else {
                    LOGGER.error("unknown cell data type");
                    return null;
                }
                if (parseParam.getCellFormat() != null) {
                    cellValue = parseParam.getCellFormat().format(columnChar, cellValue);
                }
                FileParseCommonUtil.invokeValue(t, entry.getValue(), cellValue);
            }
            if (parseParam.getBusinessDefineParse() != null) {
                parseParam.getBusinessDefineParse().defineParse(t, cellDataMap, parseParam);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
}

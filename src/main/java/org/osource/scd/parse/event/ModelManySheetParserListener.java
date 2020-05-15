package org.osource.scd.parse.event;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.read.listener.ReadListener;
import org.osource.scd.param.ParseParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author chengdu
 *
 */
public class ModelManySheetParserListener<T> implements ReadListener<Map<Integer, CellData>> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ModelManySheetParserListener.class);

    private Map<Integer, ParseParam> parseParamMap;

    private Map<Integer, List<T>> resultMap;

    private Class<T> clazz;

    public ModelManySheetParserListener(Map<Integer, ParseParam> parseParamMap ,
                                        Map<Integer, List<T>> resultMap, Class<T> clazz) {
        this.parseParamMap = parseParamMap;
        this.resultMap = resultMap;
        this.clazz = clazz;
    }

    @Override
    public void onException(Exception e, AnalysisContext analysisContext) {
    }

    @Override
    public void invokeHead(Map<Integer, CellData> cell, AnalysisContext analysisContext) {
    }

    @Override
    public void invoke(Map<Integer, CellData> cellDataMap, AnalysisContext analysisContext) {
        Integer sheetNo = analysisContext.readSheetHolder().getSheetNo();
        int rowIndex = analysisContext.readRowHolder().getRowIndex();
        // 如果需要解析 此页数据
        ParseParam parseParam = parseParamMap.get(sheetNo);
        if (parseParam != null) {
            List<T> resultList = resultMap.get(sheetNo);
            if (resultList == null) {
                resultList = new ArrayList<>();
                resultMap.put(sheetNo, resultList);
            }
            if (rowIndex >= parseParam.getStartLine()) {
                parseModelToResultList(cellDataMap, analysisContext, parseParam, resultList);
            }
            if (parseParam.getDataConsumer() != null) {
                if (resultList.size() >= parseParam.getBatchNum()) {
                    parseParam.getDataConsumer().accept(resultList, sheetNo);
                    resultList.clear();
                }
            }
        }
    }

    /**
     * 一行数据解析到模型 并加入 List
     * @param cellDataMap
     * @param analysisContext
     * @param parseParam
     * @param resultList
     */
    private void parseModelToResultList(Map<Integer, CellData> cellDataMap, AnalysisContext analysisContext,
                                        ParseParam parseParam, List<T> resultList) {
        T t = ModelParserCommon.convertCellDataMapToVo(cellDataMap, analysisContext, clazz, parseParam);
        if (t != null) {
            resultList.add(t);
        } else {
            int rowIndex = analysisContext.readRowHolder().getRowIndex();
            LOGGER.error("convert row data to vo error {}", cellDataMap);
            parseParam.getErrorRecord()
                    .writeErrorMsg("line " + rowIndex + ":" + cellDataMap +
                            "covert to null");
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        parseParamMap.forEach(this::consumerLeftList);
    }

    @Override
    public boolean hasNext(AnalysisContext analysisContext) {
        return true;
    }

    public void consumerLeftList(Integer key, ParseParam parseParam) {
        if (parseParam != null && parseParam.getDataConsumer() != null) {
            List<T> sheetResult = resultMap.get(key);
            if (sheetResult != null && sheetResult.size() > 0) {
                parseParam.getDataConsumer().accept(sheetResult, key);
                sheetResult.clear();
            }
        }
    }
}

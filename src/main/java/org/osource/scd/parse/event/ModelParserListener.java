package org.osource.scd.parse.event;


import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.read.listener.ModelBuildEventListener;
import com.alibaba.excel.read.listener.ReadListener;
import org.osource.scd.param.ParseParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * @author chengdu
 *
 */
public class ModelParserListener<T> implements ReadListener<Map<Integer, CellData>> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ModelBuildEventListener.class);

    private ParseParam parseParam;

    private List<T> resultList;

    private Class<T> clazz;

    public ModelParserListener(ParseParam parseParam, List<T> resultList, Class<T> clazz) {
        this.parseParam = parseParam;
        this.resultList = resultList;
        this.clazz = clazz;
    }


    @Override
    public void onException(Exception e, AnalysisContext analysisContext) throws Exception {
    }

    @Override
    public void invokeHead(Map<Integer, CellData> map, AnalysisContext analysisContext) {

    }

    @Override
    public void invoke(Map<Integer, CellData> cellDataMap, AnalysisContext analysisContext) {
        // convert cell data to model
        T t = ModelParserCommon.convertCellDataMapToVo(cellDataMap, analysisContext, clazz, parseParam);
        if (t != null) {
            resultList.add(t);
        } else {
                int rowIndex = analysisContext.readRowHolder().getRowIndex();
                parseParam.getErrorRecord()
                        .writeErrorMsg("line " + rowIndex + ":" + cellDataMap +
                                "covert to null");
        }
        if (parseParam.getDataConsumer() != null) {
            if (resultList.size() >= parseParam.getBatchNum()) {
                Integer sheetNum = analysisContext.readSheetHolder().getSheetNo();
                parseParam.getDataConsumer().accept(resultList, sheetNum);
                resultList.clear();
            }
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        if (parseParam.getDataConsumer() != null) {
            if (resultList.size() > 0) {
                LOGGER.info("consumer left data size {}", resultList.size());
                Integer sheetNum = analysisContext.readSheetHolder().getSheetNo();
                parseParam.getDataConsumer().accept(resultList, sheetNum);
                resultList.clear();
            }
        }
    }

    @Override
    public boolean hasNext(AnalysisContext analysisContext) {
        return true;
    }
}

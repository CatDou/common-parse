package org.osource.scd.parse.event;


import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.context.AnalysisContextImpl;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.read.listener.ModelBuildEventListener;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.read.metadata.holder.ReadHolder;
import com.alibaba.excel.util.ConverterUtils;
import org.osource.scd.param.ParseParam;
import org.osource.scd.utils.FileParseCommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * @author chengdu
 * @date 2020/2/29
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

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    @Override
    public boolean hasNext(AnalysisContext analysisContext) {
        return true;
    }

    public List<T> getResultList() {
        return resultList;
    }
}

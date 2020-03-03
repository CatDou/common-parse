package org.osource.scd.parse;

import org.osource.scd.param.ParseParam;

import java.util.List;
import java.util.Map;

/**
 * @author chengdu
 *
 */
public interface FileParse {
    <T> List<T> parseFile(String filePath, Class<T> clazz, ParseParam parseParam);

    default void checkParam(ParseParam parseParam) {
        if (parseParam.getFieldSetterMap() == null ||
                parseParam.getFieldSetterMap().size() == 0) {
            throw new IllegalArgumentException("please check field setter mapper");
        }
    }

    /**
     * parse many sheet
     * @param filePath file path
     * @param clazz clazz
     * @param parseParamMap parse param map
     * @param <T> T
     * @return many sheet result
     */
    <T> Map<Integer, List<T>> parseFileSheets(String filePath, Class<T> clazz,  Map<Integer, ParseParam> parseParamMap);
}

package org.osource.scd.parse;


import org.osource.scd.param.ParseParam;

/**
 * @author chengdu
 * @date 2020/1/12
 */
public interface BusinessDefineParse {
    <T> void defineParse(T t, Object rowData, ParseParam parseParam);
}

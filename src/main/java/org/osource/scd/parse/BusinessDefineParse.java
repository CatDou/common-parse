package org.osource.scd.parse;


import org.osource.scd.param.ParseParam;

/**
 * @author chengdu
 *
 */
public interface BusinessDefineParse {
    <T> void defineParse(T t, Object rowData, ParseParam parseParam);
}

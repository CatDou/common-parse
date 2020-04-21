package org.osource.scd.parse.define;


import org.osource.scd.param.ParseParam;

/**
 * @author chengdu
 *
 */
public interface RowDefineParse<T> {
    void defineParse(T t, Object rowData, ParseParam parseParam);
}

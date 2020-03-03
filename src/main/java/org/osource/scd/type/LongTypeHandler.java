package org.osource.scd.type;

/**
 * @author chengdu
 *
 */
public class LongTypeHandler implements BaseTypeHandler{

    @Override
    public Object convertStrToType(String input) {
        return Long.valueOf(input);
    }
}

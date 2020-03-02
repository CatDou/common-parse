package org.osource.scd.type;

/**
 * @author chengdu
 * @date 2020/1/12
 */
public class BooleanTypeHandler implements BaseTypeHandler {
    @Override
    public Object convertStrToType(String input) {
        return Boolean.valueOf(input);
    }
}

package org.osource.scd.type;

/**
 * @author chengdu
 * @date 2019/8/30.
 */
public class DoubleTypeHandler implements BaseTypeHandler {
    @Override
    public Object convertStrToType(String input) {
        return Double.valueOf(input);
    }
}

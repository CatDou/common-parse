package org.osource.scd.type;

/**
 * @author chengdu
 *
 */
public class BooleanTypeHandler implements BaseTypeHandler {
    @Override
    public Object convertStrToType(String input) {
        return Boolean.valueOf(input);
    }
}

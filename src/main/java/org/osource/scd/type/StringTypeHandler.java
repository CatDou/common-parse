package org.osource.scd.type;

/**
 * @author chengdu
 *
 */
public class StringTypeHandler implements BaseTypeHandler {
    @Override
    public Object convertStrToType(String input) {
        return String.valueOf(input);
    }
}

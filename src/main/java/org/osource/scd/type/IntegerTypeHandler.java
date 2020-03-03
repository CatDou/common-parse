package org.osource.scd.type;

/**
 * @author chengdu
 *
 */
public class IntegerTypeHandler implements BaseTypeHandler {
    @Override
    public Object convertStrToType(String input) {
        // 小数点数据转换为 1
        int dotIndex = input.indexOf(".");
        if (dotIndex != -1) {
            input = input.substring(0, dotIndex);
        }
        return Integer.valueOf(input);
    }
}

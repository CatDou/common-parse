package org.osource.scd.parse.error;

/**
 * @author chengdu
 * @date 2020/1/12
 */
public abstract class ErrorRecord {

    public abstract void writeErrorMsg(String errorInfo);

    public abstract String getErrorMsg();
}

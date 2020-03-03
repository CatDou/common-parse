package org.osource.scd.parse.error;

/**
 * @author chengdu
 *
 */
public abstract class ErrorRecord {

    public abstract void writeErrorMsg(String errorInfo);

    public abstract String getErrorMsg();
}

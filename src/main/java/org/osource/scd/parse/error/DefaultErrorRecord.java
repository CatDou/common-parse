package org.osource.scd.parse.error;

/**
 * @author chengdu
 *
 */
public class DefaultErrorRecord extends ErrorRecord {

    private StringBuilder errorMsg;

    public DefaultErrorRecord(StringBuilder errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public void writeErrorMsg(String errorInfo) {
        errorMsg.append(errorInfo);
    }

    @Override
    public String getErrorMsg() {
        return errorMsg.toString();
    }
}

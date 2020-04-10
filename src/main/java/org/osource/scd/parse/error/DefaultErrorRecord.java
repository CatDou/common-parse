package org.osource.scd.parse.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chengdu
 *
 */
public class DefaultErrorRecord extends ErrorRecord {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultErrorRecord.class);

    private static final int MAX_SIZE = 1000000;

    private StringBuilder errorMsg;

    public DefaultErrorRecord(StringBuilder errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public void writeErrorMsg(String errorInfo) {
        // out of memory
        if (errorMsg.length() > MAX_SIZE) {
            LOGGER.info("error msg is too long, maybe you should define a consumer");
            errorMsg.setLength(0);
        }
        errorMsg.append(errorInfo);
    }

    @Override
    public String getErrorMsg() {
        return errorMsg.toString();
    }
}

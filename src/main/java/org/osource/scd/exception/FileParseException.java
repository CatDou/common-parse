package org.osource.scd.exception;

/**
 * @author chengdu
 * @date 2020/1/12
 */
public class FileParseException extends RuntimeException {
    public FileParseException() {
    }

    public FileParseException(String message) {
        super(message);
    }

    public FileParseException(String message, Throwable cause) {
        super(message, cause);
    }
}

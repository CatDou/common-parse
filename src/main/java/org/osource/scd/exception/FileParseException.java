package org.osource.scd.exception;

/**
 * @author chengdu
 *
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

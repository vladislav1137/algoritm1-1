package org.example.Exceptions;

public class NullItemsException extends RuntimeException {
    public NullItemsException() {
    }

    public NullItemsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullItemsException(Throwable cause) {
        super(cause);
    }

    public NullItemsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public NullItemsException(String message) {
        super(message);
    }
}
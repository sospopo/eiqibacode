package com.laiwanba.exception;

/**
 * Created by chunmiao on 17-3-29.
 */
public class StatusWrongException extends RuntimeException{
    public StatusWrongException(String message) {
        super(message);
    }

    public StatusWrongException(String message, Throwable cause) {
        super(message, cause);
    }
}

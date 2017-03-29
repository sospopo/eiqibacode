package com.laiwanba.exception;

/**
 * Created by chunmiao on 17-3-29.
 */
public class ObjectCannotMatchException extends RuntimeException{
    public ObjectCannotMatchException(String message) {
        super(message);
    }

    public ObjectCannotMatchException(String message, Throwable cause) {
        super(message, cause);
    }
}

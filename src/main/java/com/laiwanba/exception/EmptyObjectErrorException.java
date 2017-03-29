package com.laiwanba.exception;

/**
 * Created by chunmiao on 17-3-29.
 */
public class EmptyObjectErrorException extends RuntimeException{
    public EmptyObjectErrorException(String message) {
        super(message);
    }

    public EmptyObjectErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}

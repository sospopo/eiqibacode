package com.laiwanba.exception;

/**
 * Created by chunmiao on 17-3-5.
 */
public class SystemErrorException extends RuntimeException{
    public SystemErrorException(String message) {
        super(message);
    }

    public SystemErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}

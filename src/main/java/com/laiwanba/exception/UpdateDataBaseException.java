package com.laiwanba.exception;

/**
 * Created by chunmiao on 17-3-29.
 */
public class UpdateDataBaseException extends RuntimeException{
    public UpdateDataBaseException(String message) {
        super(message);
    }

    public UpdateDataBaseException(String message, Throwable cause) {
        super(message, cause);
    }
}

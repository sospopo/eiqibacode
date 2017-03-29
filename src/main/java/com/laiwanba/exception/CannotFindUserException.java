package com.laiwanba.exception;

/**
 * Created by chunmiao on 17-3-29.
 */
public class CannotFindUserException extends RuntimeException{
    public CannotFindUserException(String message) {
        super(message);
    }

    public CannotFindUserException(String message, Throwable cause) {
        super(message, cause);
    }
}

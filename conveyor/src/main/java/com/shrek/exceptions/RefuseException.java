package com.shrek.exceptions;

public class RefuseException extends CustomException{
    public RefuseException(int code, String message) {
        super(code, message);
    }
}

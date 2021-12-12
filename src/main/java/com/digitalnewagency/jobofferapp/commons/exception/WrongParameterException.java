package com.digitalnewagency.jobofferapp.commons.exception;

import org.springframework.http.HttpStatus;

public class WrongParameterException extends JobOfferException{
    public WrongParameterException(String message) {
        super(message);
    }

    public WrongParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongParameterException(String message, Throwable cause, String errorCode, String errorId) {
        super(message, cause, errorCode, errorId);
    }

    public WrongParameterException(String message, String errorCode, String errorId) {
        super(message, errorCode, errorId);
    }

    @Override
    public HttpStatus getStatus(){
        return HttpStatus.NOT_FOUND;
    }
}

package com.digitalnewagency.jobofferapp.commons.exception;

import org.springframework.http.HttpStatus;

public class NoDataFoundException  extends JobOfferException{

    public NoDataFoundException(String message) {
        super(message);
    }

    public NoDataFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoDataFoundException(String message, Throwable cause, String errorCode, String errorId) {
        super(message, cause, errorCode, errorId);
    }

    public NoDataFoundException(String message, String errorCode, String errorId) {
        super(message, errorCode, errorId);
    }

    @Override
    public HttpStatus getStatus(){
        return HttpStatus.NOT_FOUND;
    }
}

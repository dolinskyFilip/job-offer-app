package com.digitalnewagency.jobofferapp.commons.exception;

import org.springframework.http.HttpStatus;

public class JobOfferException extends RuntimeException{

    protected String errorCode;

    protected String errorId;

    public JobOfferException(String message) {
        super(message);
    }

    public JobOfferException(String message,Throwable cause) {
        super(message,cause);
    }

    public JobOfferException(String message, Throwable cause, String errorCode, String errorId) {
        super(message,cause);
        this.errorCode = errorCode;
        this.errorId=errorId;
    }

    public JobOfferException(String message, String errorCode, String errorId) {
        super(message);
        this.errorCode = errorCode;
        this.errorId=errorId;
    }

    public HttpStatus getStatus(){
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
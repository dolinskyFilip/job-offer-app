package com.digitalnewagency.jobofferapp.web.advice;

import lombok.Data;

@Data
public class ErrorResponse {
    String errorId;
    String message;
    String errorCode;
}

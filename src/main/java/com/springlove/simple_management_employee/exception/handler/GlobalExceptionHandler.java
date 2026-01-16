package com.springlove.simple_management_employee.exception.handler;

import com.springlove.simple_management_employee.exception.business.DateTimeFormatException;
import com.springlove.simple_management_employee.exception.common.AlreadyExistsException;
import com.springlove.simple_management_employee.exception.common.ResourceNotFoundException;
import com.springlove.simple_management_employee.exception.error.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleResourceNotFoundException(
            ResourceNotFoundException e) {
        ApiErrorResponse errorResponse = new ApiErrorResponse();

        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(e.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DateTimeFormatException.class)
    public ResponseEntity<ApiErrorResponse> handleDateTimeFormatException(
            DateTimeFormatException e) {
        ApiErrorResponse errorResponse = new ApiErrorResponse();

        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(e.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ApiErrorResponse> handleAlreadyExistsException(
            AlreadyExistsException e) {
        ApiErrorResponse errorResponse = new ApiErrorResponse();

        errorResponse.setStatus(HttpStatus.CONFLICT.value());
        errorResponse.setMessage(e.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }
}

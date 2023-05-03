package com.example.course.exception;
/*
 * author Fushtei Maksym
 * project course
 * classname ApiExceptionHandler
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 9/22/2022
 * Copyright notice
 */


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

     @ExceptionHandler(value = {ApiRequestException.class})
     public ResponseEntity<Object> handleApiRequestException(ApiRequestException apiRequestException){

          ApiException apiException = new ApiException(
                  apiRequestException.getMessage(),
                  apiRequestException,
                  HttpStatus.NOT_FOUND,
                  ZonedDateTime.now()
          );

          return new ResponseEntity<>(apiException, apiException.getHttpStatus());
     }
}

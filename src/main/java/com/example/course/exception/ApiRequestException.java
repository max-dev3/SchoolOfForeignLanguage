package com.example.course.exception;
/*
 * author Fushtei Maksym
 * project course
 * classname ApiRequestException
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 9/22/2022
 * Copyright notice
 */


public class ApiRequestException extends RuntimeException{

     public ApiRequestException(String message) {
          super(message);
     }

     public ApiRequestException(String message, Throwable cause) {
          super(message, cause);
     }
}

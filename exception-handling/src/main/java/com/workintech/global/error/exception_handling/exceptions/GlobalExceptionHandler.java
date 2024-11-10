package com.workintech.global.error.exception_handling.exceptions;

//Spring Bean (class)
// interceptor

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
        @ExceptionHandler
        public ResponseEntity<StudentErrorResponse> handleException(StudentException studentException){

                StudentErrorResponse errorResponse = new StudentErrorResponse(studentException.getStatus().value(),
                        studentException.getMessage(),System.currentTimeMillis());

                return new ResponseEntity<>(errorResponse,studentException.getStatus());

        }
        @ExceptionHandler
        public ResponseEntity<StudentErrorResponse> handleException(Exception exception){
                StudentErrorResponse errorResponse = new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(),exception.getMessage(),System.currentTimeMillis());
                return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
        }

}

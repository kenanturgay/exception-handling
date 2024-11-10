package com.workintech.global.error.exception_handling.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class StudentException extends RuntimeException{

    private HttpStatus status;

    public StudentException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}

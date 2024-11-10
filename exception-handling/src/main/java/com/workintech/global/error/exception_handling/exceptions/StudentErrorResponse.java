package com.workintech.global.error.exception_handling.exceptions;


//Her requeatin bir http status coeları olur.
//


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentErrorResponse {

    private int status;
    private String message;
    private long timestamp;
}

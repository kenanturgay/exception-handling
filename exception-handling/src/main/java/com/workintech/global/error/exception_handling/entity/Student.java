package com.workintech.global.error.exception_handling.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private int grade;
    private boolean isSuccessful;


}


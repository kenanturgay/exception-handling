package com.workintech.global.error.exception_handling.controller;

import com.workintech.global.error.exception_handling.entity.Student;
import com.workintech.global.error.exception_handling.exceptions.StudentException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentController {

    private Map<Long, Student> students;

    @PostConstruct// Reacttaki UseEffect'tin dependency almayanına benzer.
    public void init(){
        students=new HashMap<>();
        students.put(1L,new Student(1,"KENAN", "TURGAY", 98, true));
    }


    public StudentController(){
        System.out.println("Constructor");
    }

    @GetMapping("/")
    public List<Student> findAll(){
        return students.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable Long id){

        if(id<=0){
            throw new StudentException("Must be greater than 0", HttpStatus.BAD_REQUEST);
        }

        if(!students.containsKey(id)){
            throw new StudentException("Student with given id is not found", HttpStatus.NOT_FOUND);
        }
        return students.get(id);
    }
}

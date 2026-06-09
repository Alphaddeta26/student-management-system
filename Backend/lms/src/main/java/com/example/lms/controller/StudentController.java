package com.example.lms.controller;


import com.example.lms.model.Student;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/students")
@CrossOrigin("*")

public class StudentController{

    @GetMapping
    public Student getStudent(){
        return new Student(1,"Shiv", "CSE");
        

    }
}
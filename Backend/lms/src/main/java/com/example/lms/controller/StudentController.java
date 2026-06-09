package com.example.lms.controller;

import com.example.lms.model.Student;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {

    @GetMapping
    
    public ArrayList<Student> getStudent(){

        ArrayList<Student> students = new ArrayList<>();
        students.add(
                new Student(1, "Shivam", "MCA")
            );

            students.add(
                new Student(2, "Akkash", "cse")
            );
        
        return students;
    }
}
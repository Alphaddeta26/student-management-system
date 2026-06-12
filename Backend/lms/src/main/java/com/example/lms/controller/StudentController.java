package com.example.lms.controller;

import com.example.lms.model.Student;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController{
    @GetMapping
    public ArrayList<Student> getStudents(){
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Shiv", "CSE"));
        students.add(new Student(2, "Raghav", "cse"));
        return students;

    }
}
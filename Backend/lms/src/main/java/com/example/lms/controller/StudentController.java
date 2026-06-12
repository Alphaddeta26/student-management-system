package com.example.lms.controller;

import com.example.lms.model.Student;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController{
    @GetMapping
    public ArrayList<Student> getStudents(){
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Shiv", "CSE"));
        students.add(new Student(2, "Raghav", "cse"));
        students.add(new Student(3, "Aman", "Bca"));
        students.add(new Student(2, "Rahul", "Mca"));
        students.add(new Student(3, "Ajay", "Mca"));
        return students;

    }
    @GetMapping("/bca")
    public List<Student> getBcaStudents(){
        return getStudents().stream().filter(student -> "Bca".equals(student.getCourse())).collect(Collectors.toList());
            }
    
    @GetMapping("/names")
    public List<String> getNames(){
        return getStudents().stream().map(Student :: getName).collect(Collectors.toList());
    }
}
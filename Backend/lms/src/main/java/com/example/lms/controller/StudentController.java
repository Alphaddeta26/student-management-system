package com.example.lms.controller;

import com.example.lms.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController{
     @Autowired
        JdbcTemplate jdbcTemplate;
        @GetMapping("/count")
        public int countStudent(){
            String sql = "SELECT COUNT(*) from students";

            return jdbcTemplate.queryForObject(
                sql,
                Integer.class
            );
        }
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
package com.example.lms.controller.Service.Database;

import org.springframework.stereotype.Service;

import com.example.lms.repository.StudentRepository;
import com.example.lms.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class StudentService {

    private final StudentRepository repository;

	    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    @Autowired
    JdbcTemplate jdbcTemplate;


    public Integer getStudentCount() {

        String sql = "SELECT COUNT(*) FROM students";

        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    public String getMessage() {

        return "Student Service Working";

    }

    public Student saveStudent(Student student){
        return repository.save(student);

    }

}
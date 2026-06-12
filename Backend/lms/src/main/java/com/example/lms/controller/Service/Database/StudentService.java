package com.example.lms.controller.Service.Database;

import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class StudentService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public Integer getStudentCount() {

        String sql = "SELECT COUNT(*) FROM students";

        return jdbcTemplate.queryForObject(sql,Integer.class);
    }
    public String getMessage() {

        return "Student Service Working";

    }

}
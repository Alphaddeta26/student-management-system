package com.example.lms.controller.Service.Database;

import org.springframework.stereotype.Service;
import com.example.lms.dto.StudentRequestDTO;
import com.example.lms.repository.StudentRepository;
import com.example.lms.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.lms.exception.StudentNotFoundException;

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
    public Student getStudentById(Integer id){
        return repository.findById(id)
            .orElseThrow( () -> new StudentNotFoundException("Student Not Found")
    );
       
    }
    public Student addStudent(StudentRequestDTO dto ){
        Student student = new Student();
        student.setName(dto.getName());
        student.setCourse(dto.getCourse());

        return repository.save(student);
    }

}
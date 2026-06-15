package com.example.lms.controller;

import com.example.lms.controller.Service.Database.StudentService;
import com.example.lms.dto.StudentResponseDTO;
import com.example.lms.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.example.lms.dto.StudentRequestDTO;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController{
     
        private final StudentService service;
        public StudentController(StudentService service){
            this.service = service;
        }

        @GetMapping("/count")
        public Integer countStudents(){
            return service.getStudentCount();
        }
        @GetMapping("/message")
        public String getMessage(){
            return service.getMessage();

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

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable Integer id){
        Student student = service.getStudentById(id);
        StudentResponseDTO response =new StudentResponseDTO(student.getId(),
        student.getName(),
        student.getCourse()
        
    );
        return ResponseEntity.ok(response);
    }
    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody StudentRequestDTO dto){
        Student student = service.addStudent(dto);
        return ResponseEntity.ok(student);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id, @RequestBody StudentRequestDTO dto){
        return ResponseEntity.ok(service.updateStudent(id, dto)
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id){
        return ResponseEntity.ok(service.deleteStudent(id));
    }
}
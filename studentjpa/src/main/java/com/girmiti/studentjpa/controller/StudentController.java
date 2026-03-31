package com.girmiti.studentjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import com.girmiti.studentjpa.entity.Student;
import com.girmiti.studentjpa.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // Save student
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    // Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    // Get by ID
    @GetMapping("/{id}")
    public Optional<Student> getStudent(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    // Delete student
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }
}
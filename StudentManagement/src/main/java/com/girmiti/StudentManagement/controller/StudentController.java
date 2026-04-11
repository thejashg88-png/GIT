package com.girmiti.StudentManagement.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.girmiti.StudentManagement.dto.StudentDTO;
import com.girmiti.StudentManagement.entity.Student;
import com.girmiti.StudentManagement.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public Student create(@RequestBody StudentDTO dto) {
        return service.createStudent(dto);
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAllStudents();
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody StudentDTO dto) {
        return service.updateStudent(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteStudent(id);
        return "Deleted";
    }
}

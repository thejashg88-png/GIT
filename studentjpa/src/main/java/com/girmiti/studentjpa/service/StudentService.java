package com.girmiti.studentjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.girmiti.studentjpa.entity.Student;
import com.girmiti.studentjpa.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    // Save student
    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    // Get all students
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // Get by ID
    public Optional<Student> getStudentById(Long id) {
        return repo.findById(id);
    }

    // Delete student
    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}
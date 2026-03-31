package com.girmiti.studentapi.service;

import com.girmiti.studentapi.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

    // GET all
    public List<Student> getAllStudents() {
        return students;
    }

    // GET by ID
    public Student getStudentById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // POST
    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    // PUT
    public Student updateStudent(int id, Student updatedStudent) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(updatedStudent.getName());
                s.setCourse(updatedStudent.getCourse());
                return s;
            }
        }
        return null;
    }

    // DELETE
    public String deleteStudent(int id) {
        students.removeIf(s -> s.getId() == id);
        return "Student deleted";
    }
}
package com.girmiti.StudentManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.girmiti.StudentManagement.dto.StudentDTO;
import com.girmiti.StudentManagement.entity.Address;
import com.girmiti.StudentManagement.entity.Student;
import com.girmiti.StudentManagement.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    // 🔥 CREATE Student with Addresses
    public Student createStudent(StudentDTO dto) {

        // Step 1: Create Student
        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());

        // Step 2: Convert AddressDTO → Address Entity
        List<Address> addressList = dto.getAddresses()
                .stream()
                .map(a -> {
                    Address address = new Address();
                    address.setCity(a.getCity());
                    address.setState(a.getState());

                    // 🔥 VERY IMPORTANT (RELATIONSHIP FIX)
                    address.setStudent(student);

                    return address;
                })
                .toList();

        // Step 3: Set addresses to student
        student.setAddresses(addressList);

        // Step 4: Save (cascade will save addresses also)
        return repo.save(student);
    }

    // 🔥 READ all students
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // 🔥 UPDATE student
    public Student updateStudent(Long id, StudentDTO dto) {

        Student student = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());

        return repo.save(student);
    }

    // 🔥 DELETE student
    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}

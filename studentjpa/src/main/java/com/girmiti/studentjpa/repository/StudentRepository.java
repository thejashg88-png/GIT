package com.girmiti.studentjpa.repository;

import com.girmiti.studentjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
}
package com.girmiti.e_m.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.girmiti.e_m.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee , Long> {

}

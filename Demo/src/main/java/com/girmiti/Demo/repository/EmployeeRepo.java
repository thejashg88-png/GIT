package com.girmiti.Demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.girmiti.Demo.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee , Long>{

}

package com.girmiti.e_m.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.girmiti.e_m.entity.Employee;
import com.girmiti.e_m.service.EmployeeService;

@RestController
@RequestMapping("/hr")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee emp) {
        return service.save(emp);
    }

    @GetMapping("/employees")
    public List<Employee> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/employee/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

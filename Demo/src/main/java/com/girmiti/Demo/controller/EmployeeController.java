package com.girmiti.Demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.girmiti.Demo.entity.Employee;
import com.girmiti.Demo.service.EmpoService;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	
	@Autowired
	private EmpoService Empser;
	
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee)
	{
		return Empser.saveEmpo(employee);
	}
	
	@GetMapping
	public List<Employee> getemployee()
	{
		return Empser.getAllEmployee();
	}
	
	@GetMapping("/{id}")
	public Optional<Employee> getemployeebyid(@PathVariable Long id)
	{
		return Empser.getEmployeeById(id);
		
	}
	@DeleteMapping("/delete/{id}")
	public void deletebyid(@PathVariable Long id)
	{
	    Empser.deleteEmployeeByID(id);
	}


}

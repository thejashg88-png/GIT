package com.girmiti.Demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.girmiti.Demo.entity.Employee;
import com.girmiti.Demo.repository.EmployeeRepo;

@Service
public class EmpoService {
	
	@Autowired 
	private EmployeeRepo repo;
	
	
	public Employee saveEmpo(Employee emp)
	{
		return repo.save(emp);
	}
	
	public List<Employee> getAllEmployee(){
		return repo.findAll();
	}
	
	public Optional<Employee> getEmployeeById(Long id) {
		return repo.findById(id);
	}
	
	public void deleteEmployeeByID(Long id)
	{
		 repo.deleteById(id);
	}

}

package com.girmiti.demo3.controller;

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


import com.girmiti.demo3.entity.Student;
import com.girmiti.demo3.service.Student_Service;



@RestController
@RequestMapping("/student")
public class Student_Contoller {
	
	@Autowired
	private Student_Service serv;
	
	@PostMapping("/")
	public Student Create_con(@RequestBody Student student)
	{
		return serv.Insert_Stu(student);
	}
	
	
	@GetMapping("/")
	public List<Student> get_all_the_user()
	{
		return serv.select_stu();
	}
	
	
	@GetMapping("/{id}")
	public Optional<Student> get_By_Id(@PathVariable Long id)
	{
		return serv.select_stu_by_id(id);
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public String delete_by_id(@PathVariable Long id)
	{
		 serv.delete_by_id(id);
		 System.out.println("DELETED");
		 return "DELETED";
		 
	}
	@DeleteMapping("/delete")
    public String deleteall()
    {
		serv.delete_all();
		 System.out.println("ALL DELETED");
		return "ALL DELETED";
    
    }
}

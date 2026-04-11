package com.girmiti.demo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.girmiti.demo3.entity.Student;
import com.girmiti.demo3.repository.Student_Repository;

@Service
public class Student_Service {
	
	@Autowired
	private Student_Repository repo;
	
	
	public Student Insert_Stu(Student student)
	{
		return repo.save(student);
	}
	
	public List<Student> select_stu()
	{
		return repo.findAll();
	}
	public Optional<Student> select_stu_by_id(Long id)
	{
		return repo.findById(id);
	}
	public void delete_by_id(Long id)
	{
		 repo.deleteById(id);
	}
    public void delete_all()
    {
    	repo.deleteAll();
    }
}

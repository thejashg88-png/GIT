package com.girmiti.demo2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.girmiti.demo2.entity.User;
import com.girmiti.demo2.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	
	
	public User create_val(User user)
	{
		return repo.save(user);
	}
	
	public List<User> get_all()
	{
		return repo.findAll();
	}
	
	
	public Optional<User> getById(Long id)
	{
		return repo.findById(id);
	}
	
   
	
	
	public void deleteById(Long id)
	{ 
		 repo.deleteById(id);
	}
	public void deleteall()
	{
		repo.deleteAll();
	}

}

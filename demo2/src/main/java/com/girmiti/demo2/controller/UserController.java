package com.girmiti.demo2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.girmiti.demo2.entity.User;
import com.girmiti.demo2.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService serv;
	
	@PostMapping("/")
	public User Create_con(@RequestBody User user)
	{
		return serv.create_val(user);
	}
	
	
	@GetMapping("/")
	public List<User> get_all_the_user()
	{
		return serv.get_all();
	}
	
	
	@GetMapping("/{id}")
	public Optional<User> get_By_Id(@PathVariable Long id)
	{
		return serv.getById(id);
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public String delete_by_id(@PathVariable Long id)
	{
		 serv.deleteById(id);
		 System.out.println("DELETED");
		 return "DELETED";
		 
	}
	@DeleteMapping("/delete")
    public String delete_all()
    {
		serv.deleteall();
		 System.out.println("ALL DELETED");
		return "ALL DELETED";
    }
	

}

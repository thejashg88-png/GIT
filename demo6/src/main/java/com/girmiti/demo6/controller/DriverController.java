package com.girmiti.demo6.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.girmiti.demo6.entity.Driver;
import com.girmiti.demo6.service.DriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {

	private DriverService serv;
	
	public DriverController(DriverService serv) {
		this.serv = serv;
	}
	
	@PostMapping("/")
	public Driver create(@RequestBody Driver driver) {
		return serv.insert(driver);
	}
	
	@GetMapping("/")
	public List<Driver> getAll(){
		return serv.getAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Driver> getById(@PathVariable Long id){
		return serv.getById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteByID(@PathVariable Long id) {
		serv.deleteById(id);
		return "DELETED";
	}
	
	
	
}

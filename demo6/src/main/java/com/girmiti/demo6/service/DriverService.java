package com.girmiti.demo6.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.girmiti.demo6.entity.Driver;
import com.girmiti.demo6.repository.DriverRepository;

@Service
public class DriverService {
	
	private DriverRepository repo;
	
	public DriverService(DriverRepository repo) {
	
		this.repo = repo;
	}
	
	public Driver insert(Driver driver) {
		return repo.save(driver);
	}
	
	
	public List<Driver> getAll(){
		return repo.findAll();
	}
	
	public Optional<Driver> getById(Long id) {
		return repo.findById(id);
	}
	
	public void deleteById(Long id) {
		repo.deleteById(id);
	}

}

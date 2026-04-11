package com.girmiti.demo4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.girmiti.demo4.entity.Worker;
import com.girmiti.demo4.repository.WorkerRepository;

@Service
public class WorkerService {
	
	@Autowired
	private WorkerRepository repo;
	
	public Worker insert(Worker worker) {
		return repo.save(worker);
		
	}
	public List<Worker> getAllWorker(){
		return repo.findAll();
	}
	
	public Optional<Worker> getById(Long id) {
		return repo.findById(id);
	}
	
	public void deleteById(Long id) {
		repo.deleteById(id);
	}
	public void deleteAll() {
	      repo.deleteAll();
	}
	
}

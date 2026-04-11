package com.girmiti.demo4.controller;

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

import com.girmiti.demo4.entity.Worker;
import com.girmiti.demo4.service.WorkerService;

@RestController
@RequestMapping("/worker")
public class WorkerController {
	
	@Autowired
	private WorkerService serv;
	
	@PostMapping("/")
	public Worker create(@RequestBody Worker worker)
	{
		return serv.insert(worker);
	}
	
	@GetMapping("/")
	public List<Worker> getAll(){
		return serv.getAllWorker();
	}
	
	@GetMapping("/{id}")
	public Optional<Worker> getByid(@PathVariable Long id) {
		return serv.getById(id);
	}
	
	@DeleteMapping("/delete")
    public String delete() {
		serv.deleteAll();
		return "ALL DELETED";
	}
	@DeleteMapping("/delete/{id}")
	public String deletebyid(@PathVariable Long id)
	{
		serv.deleteById(id);
		return "DELETED";
	}
}

package com.girmiti.demo4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.girmiti.demo4.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker , Long>{

	
}

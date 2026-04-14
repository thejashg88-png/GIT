package com.girmiti.demo6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.girmiti.demo6.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver , Long> {

}

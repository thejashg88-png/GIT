package com.girmiti.demo2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.girmiti.demo2.entity.User;

public interface UserRepo extends JpaRepository<User , Long>{

	List<User> save(Long id);

}

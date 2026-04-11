package com.girmiti.e_m.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.girmiti.e_m.entity.User;

public interface UserRepository extends JpaRepository<User , Long> {
    Optional<User> findByUsername(String username);

}

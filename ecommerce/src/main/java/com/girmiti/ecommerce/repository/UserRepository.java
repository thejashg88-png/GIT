package com.girmiti.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.girmiti.ecommerce.entity.Cart;
import com.girmiti.ecommerce.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username); 

}

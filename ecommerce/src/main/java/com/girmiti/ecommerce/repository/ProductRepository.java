package com.girmiti.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.girmiti.ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	                                                             
}

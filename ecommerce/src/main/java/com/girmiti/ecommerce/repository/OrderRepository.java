package com.girmiti.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.girmiti.ecommerce.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

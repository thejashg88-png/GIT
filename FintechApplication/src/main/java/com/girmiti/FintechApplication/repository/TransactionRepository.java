package com.girmiti.FintechApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.girmiti.FintechApplication.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}

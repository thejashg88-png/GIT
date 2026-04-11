package com.girmiti.Finance_Tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.girmiti.Finance_Tracker.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    
    // Custom query to filter by category
    List<Transaction> findByCategoryIgnoreCase(String category);
    
    // Find total spending
    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.amount < 0")
    Double getTotalExpenses();
}

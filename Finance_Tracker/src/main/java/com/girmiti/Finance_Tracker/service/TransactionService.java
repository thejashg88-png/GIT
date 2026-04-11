package com.girmiti.Finance_Tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.girmiti.Finance_Tracker.dto.TransactionDTO;
import com.girmiti.Finance_Tracker.entity.Transaction;
import com.girmiti.Finance_Tracker.repository.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public TransactionDTO createTransaction(TransactionDTO dto) {
        Transaction transaction = new Transaction();
        transaction.setDescription(dto.description());
        transaction.setAmount(dto.amount());
        transaction.setCategory(dto.category());
        
        Transaction saved = repository.save(transaction);
        
        return new TransactionDTO(
            saved.getDescription(), 
            saved.getAmount(), 
            saved.getCategory(), 
            saved.getCreatedAt().toString()
        );
    }

    public List<Transaction> getByCategory(String category) {
        return repository.findByCategoryIgnoreCase(category);
    }
}
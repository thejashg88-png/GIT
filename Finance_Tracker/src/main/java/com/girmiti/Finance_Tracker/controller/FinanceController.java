package com.girmiti.Finance_Tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.girmiti.Finance_Tracker.dto.TransactionDTO;
import com.girmiti.Finance_Tracker.entity.Transaction;
import com.girmiti.Finance_Tracker.service.TransactionService;

@RestController
@RequestMapping("/api/v1/finance")
public class FinanceController {

    @Autowired
    private TransactionService service;

    @PostMapping("/transactions")
    public ResponseEntity<TransactionDTO> addTransaction(@Validated @RequestBody TransactionDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createTransaction(dto));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Transaction>> getByCategory(@RequestParam String category) {
        return ResponseEntity.ok(service.getByCategory(category));
    }
}

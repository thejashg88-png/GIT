package com.girmiti.FintechApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.girmiti.FintechApplication.entity.Transaction;
import com.girmiti.FintechApplication.entity.User;
import com.girmiti.FintechApplication.repository.TransactionRepository;
import com.girmiti.FintechApplication.repository.UserRepository;

@Service
public class WalletService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private TransactionRepository txnRepo;

    public Double checkBalance(String username) {
        return ((User) userRepo.findByUsername(username).get()).getBalance();
    }

    public String transfer(String from, String to, Double amount) {

        User sender = (User) userRepo.findByUsername(from).get();
        User receiver = (User) userRepo.findByUsername(to).get();

        if (sender.getBalance() < amount) {
            return "Insufficient balance";
        }

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        userRepo.save(sender);
        userRepo.save(receiver);

        Transaction txn = new Transaction();
        txn.setFromUser(from);
        txn.setFromUser(to);
        txn.setAmount(amount);

        txnRepo.save(txn);

        return "Transfer successful";
    }
}

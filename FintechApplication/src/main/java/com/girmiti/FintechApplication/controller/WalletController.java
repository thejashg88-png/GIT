package com.girmiti.FintechApplication.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.girmiti.FintechApplication.service.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping("/balance")
    public Double balance(Authentication auth) {
        return walletService.checkBalance(auth.name());
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam String to,
                           @RequestParam Double amount,
                           Authentication auth) {

        return walletService.transfer(auth.name(), to, amount);
    }
}
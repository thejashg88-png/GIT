package com.girmiti.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.girmiti.ecommerce.entity.User;
import com.girmiti.ecommerce.repository.UserRepository;

import org.springframework.ui.Model;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // Show register page
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }
    

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // MUST match login.html
    }


    // Handle register form
    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        userRepository.save(user);
        System.out.println("REGISTER HIT");

        model.addAttribute("message", "Registration Successful!");

        return "login";
    }
}
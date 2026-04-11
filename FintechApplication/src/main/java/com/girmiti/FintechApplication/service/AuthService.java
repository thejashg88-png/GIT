package com.girmiti.FintechApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.girmiti.FintechApplication.entity.User;
import com.girmiti.FintechApplication.repository.UserRepository;
import com.girmiti.FintechApplication.security.JwtUtil;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private JwtUtil jwtUtil;

    public String register(User user) {
        userRepo.save(user);
        return "User Registered";
    }

    public String login(String username, Object object) {
  
       
    	User user = userRepo.findByUsername(username)
    	        .orElseThrow(() -> new RuntimeException("User not found"));
    	
    	
		if (!user.getPassword().equals(object)) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtUtil.generateToken(username);
    }
}

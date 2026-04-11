package com.girmiti.springsec;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
     
	@GetMapping("str")
	public String getstr() {
		
		return "Welcome to the class";
	}
}

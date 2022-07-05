package com.zensar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	//http://localhost:2222/all
	@GetMapping("/all")
	public String sayHello() {
		return "<h2> hello!!!</h2>";
	}
	
	@GetMapping("/admin")
	public String sayAdmin() {
		return "<h2> Admin!!!</h2>";
	}
	
	@GetMapping("/user")
	public String helloUser() {
		return "<h2> User!!!</h2>";
	}


}

package com.zensar.thymleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

	@GetMapping("/hello")
	public String Hello(Model model) {
		model.addAttribute("message", "This is Hello World Program");
		return "helloWorld";
		
	}
}

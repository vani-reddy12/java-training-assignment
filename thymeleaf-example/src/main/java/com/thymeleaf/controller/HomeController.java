package com.thymeleaf.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	// inject via application.properties
	@Value("${Homepage.message}")
	String message;

	private List<String> students = Arrays.asList("Anika","Sanvika","Jhanvika");

	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("message", message);
		model.addAttribute("students", students);

		return "homePage";
	}

	@GetMapping("/students")
	public String mainWithParam(@RequestParam(name = "name", required = false, defaultValue = "") String name,
			Model model) {

		model.addAttribute("message", name);
		model.addAttribute("students", students);

		return "homePage"; // view
	}
}

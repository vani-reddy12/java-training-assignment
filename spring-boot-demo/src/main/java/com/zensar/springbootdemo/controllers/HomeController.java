package com.zensar.springbootdemo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	//http://localhost:4444/pqr/
	@RequestMapping("/")
	public String sayhello() {
		return"<h2> Welcome to Spring boot</h2>";
	}
	
	@RequestMapping("/pqr")
		public String saypqr() {
			return "<h1>I am vani</h1>";
			}
		
	}
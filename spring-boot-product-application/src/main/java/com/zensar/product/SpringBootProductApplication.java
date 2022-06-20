package com.zensar.product;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

	@SpringBootApplication
	@ComponentScan(basePackages = {"test","com.zensar"})
	public class SpringBootProductApplication{
	
		public static void main(String... args) {
			System.out.println("You");
			SpringApplication.run(SpringBootProductApplication.class, args);
			
			System.out.println("Compiled");
			
		}

	@Bean
	  public ModelMapper modelMapper() {
		return new ModelMapper();

	}



}

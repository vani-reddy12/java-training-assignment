package com.zensar.product;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

	@SpringBootApplication
	@ComponentScan(basePackages = {"test","com.zensar"})
	//public class SpringBootProductServiceApplication extends SpringBootServletInitializer {
	@OpenAPIDefinition
	@EnableEurekaClient
	@EnableFeignClients
	public class SpringBootProductApplication{
	
		public static void main(String[] args) {
			//System.out.println("You");
			SpringApplication.run(SpringBootProductApplication.class, args);
			
			//System.out.println("Compiled");
			
		}

	@Bean
	  public ModelMapper modelMapper() {
		return new ModelMapper();

	}
	/*
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder builder) {
	 * 
	 * return super.configure(builder); }
	 */



}

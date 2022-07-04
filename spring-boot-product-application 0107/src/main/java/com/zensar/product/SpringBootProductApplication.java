package com.zensar.product;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@ComponentScan
@OpenAPIDefinition
@EnableEurekaClient

public class SpringBootProductApplication {

	public static void main(String[] args) {
		System.out.println("You");
		SpringApplication.run(SpringBootProductApplication.class, args);

		System.out.println("Compiled");

	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();

	}

}

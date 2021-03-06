package com.zensar;
	
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@ComponentScan
@OpenAPIDefinition
public class SpringBootCouponApplication {

	public static void main(String[] args) {
		System.out.println("vani");
		SpringApplication.run(SpringBootCouponApplication.class, args);
		System.out.println("manukonda");

	}

@Bean
public ModelMapper getmodelMapper() {
 return new ModelMapper();

  }
}



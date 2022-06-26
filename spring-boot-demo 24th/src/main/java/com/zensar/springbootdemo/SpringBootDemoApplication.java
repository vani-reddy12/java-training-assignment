package com.zensar.springbootdemo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@ComponentScan(basePackages = {"test","com.zensar"})
@OpenAPIDefinition
public class SpringBootDemoApplication{
	public static void main(String... args) {
		
		SpringApplication.run(SpringBootDemoApplication.class, args);
		
		
	}

@Bean
  public ModelMapper getmodelMapper() {
	return new ModelMapper();

}


}
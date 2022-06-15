package com.zensar.springbootcouponApplication;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
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

package com.shrek;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication

//(exclude= {WebMvcAutoConfiguration.class})

public class ConveyorApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(ConveyorApiApplication.class, args);
	}

}

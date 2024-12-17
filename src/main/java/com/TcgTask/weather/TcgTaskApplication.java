package com.TcgTask.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.TcgTask.weather")
public class TcgTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TcgTaskApplication.class, args);
	}
}

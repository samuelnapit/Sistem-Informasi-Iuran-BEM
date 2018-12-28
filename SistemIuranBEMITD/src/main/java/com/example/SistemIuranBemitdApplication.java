package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example", "com.example.controller", "com.example.service"})
public class SistemIuranBemitdApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemIuranBemitdApplication.class, args);
	}
}

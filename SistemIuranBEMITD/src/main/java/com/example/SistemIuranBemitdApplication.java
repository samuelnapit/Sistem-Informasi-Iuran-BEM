package com.example;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;

@SpringBootApplication
@ComponentScan({"com.example", "com.example.controller", "com.example.services"})
public class SistemIuranBemitdApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemIuranBemitdApplication.class, args);
	}
}

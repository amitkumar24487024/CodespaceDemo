package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.Data;
import com.example.demo.repository.DataRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@SpringBootApplication
@RestController
@RequestMapping("/api")
public class DemoApplication {

	@Autowired
	private DataRepository dataRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping
	public String hello() {
		return "Hello World!";
	}

	@PostMapping
	public String saveData(@RequestBody Data entity) {
		dataRepository.save(entity);
		return "Data saved";
	
	}
	

}

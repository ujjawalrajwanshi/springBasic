package com.example.FirstMiniProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.FirstMiniProject.Controller.UrlMappingController;

@SpringBootApplication
public class FirstMiniProjectApplication {

	public static void main(String[] args) {
		ApplicationContext contex = SpringApplication.run(FirstMiniProjectApplication.class, args);
		contex.getBean(UrlMappingController.class);
	}

}

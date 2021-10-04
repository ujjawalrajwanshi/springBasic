package com.example.FirstMiniProject.MyExceptions;

import org.springframework.stereotype.Component;

public class MyCustomExceptions extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public MyCustomExceptions(String message) {
		super(message);

	}	
	
}

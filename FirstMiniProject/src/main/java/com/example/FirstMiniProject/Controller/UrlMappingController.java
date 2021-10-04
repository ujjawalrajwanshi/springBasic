package com.example.FirstMiniProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.FirstMiniProject.data.UserCred;




/*
 * Starting point of the project 
 * This class is used for mapping the respective URL with the different functions
 * 
 * */
@RestController
public class UrlMappingController {

	//Check if login is done or not
	@Autowired
	private UserFunctions userfunction;
	
	
	//To Check the login is successful of not
	@PostMapping("/login")
	@ResponseBody
	public String login(@RequestBody(required=true) UserCred usercred) {
		return userfunction.login(usercred);
		
	}
	
	
	@PostMapping("/register")
	@ResponseBody
	public String register(@RequestBody(required=true) UserCred usercred) {
		return userfunction.register(usercred);
	}
	
	
	//For testing check if data is storing or not
	@GetMapping("/getalldata")
	public Iterable<UserCred> getalldata() {
		return userfunction.showalluser();
	}
	
	
}

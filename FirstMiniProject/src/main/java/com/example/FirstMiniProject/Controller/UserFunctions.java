package com.example.FirstMiniProject.Controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.FirstMiniProject.MyExceptions.MyCustomExceptions;
import com.example.FirstMiniProject.data.UserCred;
import com.example.FirstMiniProject.repo.Userdatabase;


@Component
public class UserFunctions{
	private HashMap<String, Integer> map = new HashMap<String, Integer>();
	
	@Autowired
	private Userdatabase userdatabase;
	//private UserCred top usercred;
//	@Autowired
//	private MyCustomExceptions mycustomException;
	
	public String login(UserCred usercred) throws MyCustomExceptions {
			
		//user name doesnot match
		
		if(userdatabase.existsById(usercred.getUsername().toLowerCase())==false) {
			return "This user name Does not exist please register";
		}
		
		String temp = userdatabase.findByIdUserName(usercred.getUsername().toLowerCase());
		//attempt 3 or more
		if(map.get(usercred.getUsername().toLowerCase())>=3)
		{
			return "Account Blocked";
		}
		
		else if(userdatabase.existsById(usercred.getUsername().toLowerCase())==true && temp.equals(usercred.getPassword().toLowerCase())){
			map.put(usercred.getUsername().toLowerCase(), 0);
			return "Login Successful";
			
		}
		
		int val = map.get(usercred.getUsername().toLowerCase());
		val++;
		map.put(usercred.getUsername().toLowerCase(), val);
		return "Login Failed "+(3-val)+" attempts left ";
		//return new MyCustomExceptions("Login Failed"+(3-val)+" attempts left").toString();
	}
	
	public String register(UserCred usercred) {
		
		if(map.containsKey(usercred.getUsername().toLowerCase())==true) {
			return "User EXist Already";
		}	
		userdatabase.save(usercred);
		map.put(usercred.getUsername().toLowerCase(), 0);
		return "User Registered Successfully";
	}

	public Iterable<UserCred> showalluser() {
		// TODO Auto-generated method stub
		return userdatabase.findAll();
	}

}

package com.karthik.springmvc;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public boolean isUserValid(String user,String password) {
		if(user.equals("karthik") && password.equals("dummy"))
			return true;
		
		return false;
			
	}

}

package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Login;
import com.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;
	
	
	public String signUp(Login login) {
		
		if(login.getTypeOfUser().equals("admin")){
			return "You can't create admin account";
		}else {
			boolean res = loginRepository.existsById(login.getEmailid());
			if(res) {
				return "Account exist";
			}else {
					loginRepository.save(login);
					return "Account created successfully";			
			}
		}	
	}
	
	public String signIn(Login login) {
		if(login.getTypeOfUser().equals("admin")) {
			if(loginRepository.checkLoginDetails(login.getEmailid(), login.getPassword(),login.getTypeOfUser())!=null) {
				return "admin login successfully";
			}else {
				return "failure";
			}
		}else {
			if(loginRepository.checkLoginDetails(login.getEmailid(), login.getPassword(),login.getTypeOfUser())!=null) {
				return "user login successfully";
			}else {
				return "failure";
			}
		}
		
	}
}

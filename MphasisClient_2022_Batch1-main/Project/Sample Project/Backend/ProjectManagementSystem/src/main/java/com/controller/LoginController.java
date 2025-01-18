package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Login;
import com.service.LoginService;

@RestController
@RequestMapping("login")
@CrossOrigin()		// Enable cors policy features. 
public class LoginController {

	
	// http://localhost:8080/login/signIn
	
	@Autowired
	LoginService loginService;
	
	@PostMapping(value = "signIn")
	public String signIn(@RequestBody Login ll) {
			System.out.println(ll);
		return loginService.signIn(ll);
	}
	
	
	// http://localhost:8080/login/signUp
	@PostMapping(value = "signUp")
	public String signUp(@RequestBody Login ll) {
		return loginService.signUp(ll);
	}
}

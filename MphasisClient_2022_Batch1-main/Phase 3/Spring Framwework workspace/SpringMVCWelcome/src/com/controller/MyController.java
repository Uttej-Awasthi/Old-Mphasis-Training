package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

		@RequestMapping(value = "hi",method = RequestMethod.GET)
		public ModelAndView sayHello() {
			System.out.println("I Came Here!");
			
			// logic.
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("display1.jsp");
			return mav;
		}
		
		@RequestMapping(value = "login",method = RequestMethod.GET)
		public ModelAndView openLoginPage() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("login.jsp");
			return mav;
		}
		
		@RequestMapping(value = "checkUser",method = RequestMethod.POST)
		public ModelAndView checkUser(HttpServletRequest req) {		// DI for that object. 
			String user = req.getParameter("user");
			String pass = req.getParameter("pass");
			ModelAndView mav = new ModelAndView();
			if(user.equals("Raj") && pass.equals("123")) {
					mav.setViewName("success.jsp");
			}else {
					mav.setViewName("failure.jsp");
			}
			return mav;
		}
}

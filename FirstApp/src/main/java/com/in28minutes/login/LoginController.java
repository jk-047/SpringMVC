package com.in28minutes.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping("/login")
@SessionAttributes("name")
public class LoginController {

//	@RequestMapping(value = "/hello")
//	@ResponseBody
//	public String hello() {
//		return "Hello World!!!";
//	}
	
	@Autowired
	LoginService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPageHandler(@RequestParam String name, @RequestParam String password, ModelMap model  ) {
		System.out.println(name);
		if(service.validateUser(name, password)) {
			
			model.put("name", name);
			return "welcome";
			
		}
		else {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
		
		
	}
}

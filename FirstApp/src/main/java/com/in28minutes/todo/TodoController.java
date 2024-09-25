package com.in28minutes.todo;

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
public class TodoController {

//	@RequestMapping(value = "/hello")
//	@ResponseBody
//	public String hello() {
//		return "Hello World!!!";
//	}
	
	@Autowired
	TodoService service;

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String loginPage(ModelMap model) {
		
		model.addAttribute("todos", service.retrieveTodos("in28Minutes"));
				
		return "list-todos";
	}
	
}

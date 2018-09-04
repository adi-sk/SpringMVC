package com.zycus.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  // same as component 
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello(Map<String,String> model){
		model.put("message", "Welcome to Spring MVC");  // plays as model
		
		return "hello.jsp"; //view
	}

}

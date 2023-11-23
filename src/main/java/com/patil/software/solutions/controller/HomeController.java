package com.patil.software.solutions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.patil.software.solutions.model.User;

@RestController
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "HelloWorld";
	}

	// @RequestMapping(value="/user" ,method=RequestMethod.GET)
	@GetMapping("/user")
	public User userDetail() {
		User user = new User();
		user.setId(1);
		user.setEmail("pshridhar4@gmail.com");
		user.setName("Shridhar");
		return user;
	}

	// When Data is Mandatory use @PathVariable
	@GetMapping("/{a}/{b}")
	public String addTwoNumbers(@PathVariable("a") int num1, @PathVariable("b") int num2) {
		return "The Sum of two number is " + (num1 + num2);

	}

	//Whenever input is not Mandatory go with @RequestParam
	@GetMapping("/requestParam")
	public String user(@RequestParam String name,
			@RequestParam(value = "email", required = false, defaultValue = "") String emailId) {
		return "My name is :" + name + " And mail Id is :" + emailId;

	}
}

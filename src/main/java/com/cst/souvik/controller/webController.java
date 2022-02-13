package com.cst.souvik.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cst.souvik.model.User;
import com.cst.souvik.service.WebService;

@RestController
@CrossOrigin("http://localhost:4200")
@ControllerAdvice
public class webController {
	@Autowired
	User user;
	@Autowired
	WebService service;
	@PostMapping("/get")
	public int send(@RequestBody User user)
	{  
		return service.login(user);
	}
	@PostMapping("/sign")
	public int create(@RequestBody User user)
	{
		return service.sign(user);
	}
	
	@ExceptionHandler(value = Exception.class)
	public int error()
	{
		System.out.println("Error");
		return 0;
	}
}

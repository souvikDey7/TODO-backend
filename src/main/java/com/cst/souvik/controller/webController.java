package com.cst.souvik.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cst.souvik.model.Client;
import com.cst.souvik.service.WebService;
@RestController
@CrossOrigin("*")
public class webController {

	@Autowired
	WebService service;
	@GetMapping("/check")
	public String s()
	{
		return "working";
	}
	@PostMapping("/get")
	public int send(@RequestBody Client client)
	{  
		return service.login(client);
	}
	@PostMapping("/sign")
	public String create(@RequestBody Client client)
	{
		if(service.sign(client)==1)
		return "Created";
		return "not";
	}
	
	@ExceptionHandler(value = Exception.class)
	public String error()
	{
		return "Error";
	}
}

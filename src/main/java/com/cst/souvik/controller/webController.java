package com.cst.souvik.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cst.souvik.model.Client;
import com.cst.souvik.model.bodyD;
import com.cst.souvik.service.WebService;
@RestController
@ControllerAdvice
@CrossOrigin("*")
public class webController {

	@Autowired
	WebService service;
	@GetMapping("/check")
	public String s()
		{ return "working";
		}
	@PostMapping("/get")
	public int send(@RequestBody Client client)
	{  
		return service.login(client);
	}
	@PostMapping("/sign")
	public int create(@RequestBody Client client)
	{
		return service.sign(client);
	}
	int i=0;
	@PostMapping("/enter")
	public int body(@RequestBody bodyD body)
	{
		if(body.getText().length()==0)
			return 2;
		i++;
		body.setId(i);
		return service.create(body);
	}
	
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable("id") int id) //taking id 
	{
		return service.delete(id);
	}
	@PutMapping("/update/{id}")
	public int update(@RequestBody bodyD body,@PathVariable("id") int id)
	{
		return service.update(body,id);
	}
	@PostMapping("/show")
	public Iterable<bodyD> display(@RequestBody Map<String,String> body)
	{
		List<bodyD> a=new ArrayList<>();
		service.display(body.get("username")).forEach(a::add);
		Collections.sort(a,new Comparator<bodyD>(){
			public int compare(bodyD a,bodyD b) {
			    if(a.getId()>b.getId())
			    	return -1;
			    else if(a.getId()<b.getId())
			    	return 1;
			    else
			    	return 0;
			}});
		return a;
	}
	@ExceptionHandler(value = Exception.class)
	public String error()
	{
		return "Error";
	}
}

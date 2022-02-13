package com.cst.souvik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cst.souvik.dao.dao;
import com.cst.souvik.model.User;

@Service
public class WebService {
	
	@Autowired
	dao d;
	public int sign(User a)
	{
		User user=d.findByName(a.getUsername());
		if(user==null)
		{
			d.save(a);
			return 1;
		}
		else
		return 0;
	}
	public int login(User a)
	{
		User user=d.findByName(a.getUsername());
		if(user==null)
			return 0;
		else
		{
			if(user.getPassword().equals(a.getPassword()))
					{
						return 1;
					}
			else
			{
				return 2;
			}
		}
	}
}

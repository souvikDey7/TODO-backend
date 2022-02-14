package com.cst.souvik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cst.souvik.dao.dao;
import com.cst.souvik.model.Client;

@Service
public class WebService {
	
	@Autowired
	dao d;
	public int sign(Client a)
	{
		Client client=d.findByName(a.getUsername());
		if(client==null)
		{
			d.save(a);
			return 1;
		}
		else
		return 0;
	}
	public int login(Client a)
	{
		Client client=d.findByName(a.getUsername());
		if(client==null)
			return 0;
		else
		{
			if(client.getPassword().equals(a.getPassword()))
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

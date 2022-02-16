package com.cst.souvik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cst.souvik.dao.dao;
import com.cst.souvik.dao.dao2;
import com.cst.souvik.model.Client;
import com.cst.souvik.model.bodyD;

@Service
public class WebService {
	
	@Autowired
	dao d;
	@Autowired
	dao2 d2;
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
	public int create(bodyD body)
	{
		if(body==null)
			return 0;
		d2.save(body);
			return 1;
	}
	public Iterable<bodyD> display(String username)
	{  
		return d2.findByName(username);
	}
	public int delete(int id)
	{
		try{
			d2.deleteById(id);
			return 1;
		}
		catch(Exception e) {
			return 0;
		}
	}
	public int update(bodyD body,int id)
	{
		body.setId(id);
		d2.deleteById(id);
		if(d2.save(body)!=null)
			return 1;
		return 0;
	}
}

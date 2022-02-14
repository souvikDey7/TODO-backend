package com.cst.souvik.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cst.souvik.model.Client;

@Repository
public interface dao extends CrudRepository<Client, String> {
	@Query("select u from Client u where u.username= :username")
	public Client findByName(String username);
}

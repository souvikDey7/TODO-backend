package com.cst.souvik.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cst.souvik.model.User;

@Repository
public interface dao extends CrudRepository<User, String> {
	@Query("select u from User u where u.username= :name")
	public User findByName(String name);
}

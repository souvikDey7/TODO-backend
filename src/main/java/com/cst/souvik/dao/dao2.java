package com.cst.souvik.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cst.souvik.model.bodyD;

@Repository
public interface dao2 extends CrudRepository<bodyD,Integer> {
	@Query("select b from bodyD b where b.username=:username ")
	public  Iterable<bodyD> findByName(String username);
}

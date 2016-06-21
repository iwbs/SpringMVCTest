package com.joe.smt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joe.smt.entity.Authorities;

@Repository
public interface LoginUserAuthorityRepository extends CrudRepository<Authorities, String> {

//	@Query("select username, authority from Authorities where username = ?1")
//	public List<String> findRoleByUsername(String username);
}

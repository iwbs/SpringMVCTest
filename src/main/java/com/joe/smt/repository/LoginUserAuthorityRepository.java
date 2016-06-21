package com.joe.smt.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joe.smt.entity.Authorities;

@Repository
public interface LoginUserAuthorityRepository extends CrudRepository<Authorities, String> {

	@Query("select a.id.authority from Authorities a where a.id.username = ?1")
	public Set<String> findRoleByUsername(String username);
}

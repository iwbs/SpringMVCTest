package com.joe.smt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joe.smt.entity.Users;

@Repository
public interface LoginUserRepository extends CrudRepository<Users, String> {

}

package com.joe.smt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.joe.smt.entity.Users;

@Transactional
public interface LoginUserRepository extends CrudRepository<Users, String> {

}

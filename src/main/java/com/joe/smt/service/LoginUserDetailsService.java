package com.joe.smt.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.joe.smt.entity.Users;
import com.joe.smt.repository.LoginUserAuthorityRepository;
import com.joe.smt.repository.LoginUserRepository;
import com.joe.smt.security.LoginUserDetails;

public class LoginUserDetailsService implements UserDetailsService {

	@Autowired
	LoginUserRepository loginUserRepository;

	@Autowired
	LoginUserAuthorityRepository loginUserAuthorityRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		Users user = loginUserRepository.findOne(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found: " + username);
		} else {
			Set<String> authorities = loginUserAuthorityRepository.findRoleByUsername(username);
			return new LoginUserDetails(user, authorities);
		}
	}

}

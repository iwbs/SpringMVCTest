package com.joe.smt.test.dao;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.joe.smt.entity.Users;
import com.joe.smt.repository.LoginUserAuthorityRepository;
import com.joe.smt.repository.LoginUserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml" })
public class LoginUserTest {
	
	private static final Logger logger = LogManager.getLogger(LoginUserTest.class);

	@Autowired
	LoginUserRepository loginUserRepository;

	@Autowired
	LoginUserAuthorityRepository loginUserAuthorityRepository;

	@Test
	public void checkUser() {
		Users users = loginUserRepository.findByUsername("joseph@gmail.com");
		logger.info("User ID: " + users.getUsername());
	}

	@Test
	public void checkAuthority() {
		Set<String> authorities = loginUserAuthorityRepository.findRoleByUsername("joseph@gmail.com");
		for (String authority : authorities) {
			logger.info("Authority: " + authority);
		}
	}
}

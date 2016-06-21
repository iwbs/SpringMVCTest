package com.joe.smt.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.joe.smt.entity.Users;
import com.joe.smt.repository.LoginUserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml" })
public class LoginUserTest {

	@Autowired
	LoginUserRepository loginUserRepository;

	@Test
	public void checkUser() {
		Users users = loginUserRepository.findByUsername("joseph@gmail.com");
		System.out.println(users.getDisplayname());
	}
}

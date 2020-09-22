package com.example.demo.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.pojo.UserInfo;
import com.example.demo.service.ICardService;

@SpringBootTest
public class UserInfoMapperTest {

	@Autowired
	private ICardService service;
	
	@Test
	public void testLogin() throws Exception {
		UserInfo user = service.loginByNameAndPwd("zhangsan", "123456");
		System.out.println(user);
	}
}

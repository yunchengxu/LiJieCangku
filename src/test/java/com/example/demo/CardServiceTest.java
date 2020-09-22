package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.pojo.UserInfo;
import com.example.demo.service.ICardService;
import com.example.demo.util.MD5;

@SpringBootTest
public class CardServiceTest {

	@Autowired
	private ICardService service;
	
	@Test
	public void testLogin() throws Exception{
		UserInfo userInfo = service.loginByNameAndPwd("zhangsan", MD5.enctypeMD5("haha123456"));
		System.out.println(MD5.enctypeMD5("haha123456"));
		System.out.println(userInfo);
	}
}

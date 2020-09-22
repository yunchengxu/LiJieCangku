package com.example.demo.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.pojo.Student;

@SpringBootTest
public class StudentMapperTest {

	@Autowired
	private StudentMapper stuMapper;
	
	@Test
	public void testListStudent() throws Exception{
		List<Student> list = stuMapper.listStudent();
		for (Student student : list) {
			System.out.println(student);
		}
	}
}

package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.College;
import com.example.demo.pojo.Goods;
import com.example.demo.pojo.Student;
import com.example.demo.pojo.UserInfo;

public interface ICardService {

	UserInfo loginByNameAndPwd(String userLogin,String userPasswd);
	
	List<Student> listStudent();
	
	Student queryByStudentId(Integer stuId);
	
	List<College> listCollege();
	
	Boolean updateStu(Student student);
	
	Boolean addStu(Student student);
	
	List<Goods> listGoods();
	
	Goods queryByGoodsId(Integer goodsId);
	
	Boolean deleteOneByStuId(Integer stuId);
	
	Boolean queryOneByStuLogin(String stuLogin);
	
	List<Student> findStudentsByStuName(String stuName);
	
	Boolean updateStuPwd(Integer userId,String userPasswd);
	
	UserInfo queryUserByUserId(Integer userId);
}

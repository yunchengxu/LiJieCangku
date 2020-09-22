package com.example.demo.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Student;
import com.example.demo.pojo.UserInfo;
import com.example.demo.service.ICardService;
import com.example.demo.util.MD5;

@RestController  // 相当于Controller+ResponseBody
@RequestMapping("/card")
@CrossOrigin(allowCredentials="true", allowedHeaders="*")
public class StuController {

	@Autowired
	private ICardService cardService;
	
	@RequestMapping(path = "/login",method = {RequestMethod.POST,RequestMethod.GET})
	public Boolean verifyLogin(@RequestBody UserInfo userinfo,HttpSession session) {
		System.out.println(session.getId());
		Boolean rt = false;
		System.out.println(userinfo);
		System.out.println(MD5.enctypeMD5("haha"+userinfo.getUserPasswd()));
		UserInfo user = cardService.loginByNameAndPwd(userinfo.getUserLogin(), userinfo.getUserPasswd());
		System.out.println(user);
		if(user!=null) {
			session.setAttribute("user", user);
			rt = true;
		}
		return rt;
	}
	
	@RequestMapping(path = "/username",method = {RequestMethod.POST,RequestMethod.GET})
	public UserInfo getUserName(HttpSession session) {
		System.out.println(session.getId());
		UserInfo user = (UserInfo)session.getAttribute("user");
		if(user!=null) {
			return user;
		}
		return null;
	}
	
	@RequestMapping(path = "/liststu",method = {RequestMethod.POST,RequestMethod.GET})
	public List<Student> listStudent() {
		return cardService.listStudent();
	}

	@RequestMapping(path = "/querystu",method = {RequestMethod.POST,RequestMethod.GET})
	public Student queryByStudentId(Integer stuId) {
		return cardService.queryByStudentId(stuId);
	}
	
	@RequestMapping(path = "/savestu",method = {RequestMethod.POST,RequestMethod.GET})
	public Boolean saveStudent(@RequestBody Student	student) {
		System.out.println(student);
		if(student.getStuId()!=null) {
			return cardService.updateStu(student);
		} else {
			return cardService.addStu(student);
		}
	}
	
	@RequestMapping(path = "/delstu",method = {RequestMethod.POST,RequestMethod.GET})
	public Boolean delStudent(Integer stuId) {
		return cardService.deleteOneByStuId(stuId);
	}
	
	@RequestMapping(path = "/delstudents",method = {RequestMethod.POST,RequestMethod.GET})
	public Boolean delStudents(Integer[] stuIds) {
		Boolean rt = false;
		for(int i=0;i<stuIds.length;i++) {
			rt ^= cardService.deleteOneByStuId(stuIds[i]);
		}
		return rt;
	}
	
	@RequestMapping(path = "/querystuLogin",method = {RequestMethod.POST,RequestMethod.GET})
	public Boolean queryByStuLogin(String stuLogin) {
		return cardService.queryOneByStuLogin(stuLogin);
	} 
	
	@RequestMapping(path = "/findstu",method = {RequestMethod.POST,RequestMethod.GET})
	public List<Student> queryByStuName(String stuName) {
		return cardService.findStudentsByStuName(stuName);
	}
	
	@RequestMapping(path = "/updateUserPwd",method = {RequestMethod.POST,RequestMethod.GET})
	public Boolean updateUserPwd(Integer userId,String userPasswd) {
		return cardService.updateStuPwd(userId, userPasswd);
	}
	
	@RequestMapping(path = "/queryUserPwd",method = {RequestMethod.POST,RequestMethod.GET})
	public Boolean queryUserPwd(Integer userId,String userPwd) {
		Boolean rt = false;
		UserInfo user = cardService.queryUserByUserId(userId);
		if(user!=null) {
			if(user.getUserPasswd().equals(MD5.enctypeMD5("haha"+userPwd))) {
				rt = true;
			}
		}
		return rt;
	}
}

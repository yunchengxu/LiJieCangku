package com.example.demo.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CollegeMapper;
import com.example.demo.dao.GoodsMapper;
import com.example.demo.dao.StudentMapper;
import com.example.demo.dao.UserInfoMapper;
import com.example.demo.pojo.College;
import com.example.demo.pojo.Goods;
import com.example.demo.pojo.Student;
import com.example.demo.pojo.UserInfo;
import com.example.demo.util.MD5;

@Service
public class CardServiceImpl implements ICardService{

	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private CollegeMapper collegeMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public UserInfo loginByNameAndPwd(String userLogin, String userPasswd) {
		return userInfoMapper.selectByNameAndPwd(userLogin, MD5.enctypeMD5("haha"+userPasswd));
	}

	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public List<Student> listStudent() {
		return studentMapper.listStudent();
	}

	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public Student queryByStudentId(Integer stuId) {
		return studentMapper.selectByPrimaryKey(stuId);
	}

	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public List<College> listCollege() {
		return collegeMapper.listCollege();
	}

	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
	public Boolean updateStu(Student student) {
		return studentMapper.updateByPrimaryKeySelective(student)>0;
	}

	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public List<Goods> listGoods() {
		// TODO Auto-generated method stub
		return goodsMapper.listGoods();
	}

	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public Goods queryByGoodsId(Integer goodsId) {
		return goodsMapper.selectByPrimaryKey(goodsId);
	}

	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
	public Boolean deleteOneByStuId(Integer stuId) {
		return studentMapper.deleteByPrimaryKey(stuId)>0;
	}

	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
	public Boolean addStu(Student student) {
		// 学生编号总共12位，由字母STU+年月+3位数编号组成，(STU201806001)必须唯一，自动生成
				Calendar cal = Calendar.getInstance();
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH)+1;
				String monthStr = ("0"+month).substring(month>=10?1:0);
				String prefix = "STU"+year+monthStr;   // 结果STU202008
				String maxStuNo = studentMapper.queryMaxStuNoByMonth(prefix+"%");
				student.setStuPasswd(MD5.enctypeMD5("haha"+student.getStuPasswd()));
				if(maxStuNo==null) { // 是本月的第一个
					student.setStuNo(prefix+"001");
				} else {    // 不是第一个
					String number = Integer.parseInt(maxStuNo.substring(maxStuNo.length()-3))+1+"";  // 3
					String stuNo = prefix+("00"+number).substring(number.length()-1);    // 根据数字获得指定长度的流水号
					student.setStuNo(stuNo);
				}
				return studentMapper.insertSelective(student)>0;
	}

	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public Boolean queryOneByStuLogin(String stuLogin) {
		Boolean rt = false;
		Student stu = studentMapper.queryOneByStuLogin(stuLogin);
		if(stu!=null) {
			rt = true;
		}
		return rt;
	}

	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public List<Student> findStudentsByStuName(String stuName) {
		// TODO Auto-generated method stub
		return studentMapper.findStudentsByStuName("%"+stuName+"%");
	}

	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
	public Boolean updateStuPwd(Integer userId,String userPasswd) {
		Boolean rt = false;
		UserInfo user = userInfoMapper.selectByPrimaryKey(userId);
		user.setUserPasswd(MD5.enctypeMD5("haha"+userPasswd));
		int i = userInfoMapper.updateByPrimaryKeySelective(user);
		System.out.println(MD5.enctypeMD5("haha"+userPasswd));
		if(i>0) {
			rt = true;
		}
		return rt;
	}

	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public UserInfo queryUserByUserId(Integer userId) {
		return userInfoMapper.selectByPrimaryKey(userId);
	}

}

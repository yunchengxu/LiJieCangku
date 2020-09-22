package com.example.demo.dao;

import java.util.List;

import com.example.demo.pojo.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer stuId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer stuId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    
    List<Student> listStudent();
    
    String queryMaxStuNoByMonth(String prefix);
    
    Student queryOneByStuLogin(String stuLogin);
    
    List<Student> findStudentsByStuName(String stuName);
}
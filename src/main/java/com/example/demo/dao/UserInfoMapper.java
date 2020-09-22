package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    
    UserInfo selectByNameAndPwd(@Param("userLogin") String userLogin,@Param("userPasswd") String userPasswd);
}
package com.demo.service.impl;


import com.demo.mapper.UserMapper;
import com.demo.pojo.user.User;
import com.demo.service.UserService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;

@Service
public class UserService1Impl implements UserService1 {

    @Autowired
    UserMapper userMapper;

    @Override
    public User selectUserById(String studentId) {
        return userMapper.selectUserById(studentId);
    }

    @Override
    public boolean insertUser(String userId,String studentId, String password,int status) {
        return userMapper.insertUser(userId,studentId,password,status);
    }

    @Override
    public boolean updateUser(String userId, String studentId, String password, String userName, String realName,
                              String sex, Date birthday, Date enterSchoolTime, String major, String mobilePhone, String email,
                              String selfImage, Timestamp createTime, int status, int idolSum, int fansSum) {

        return userMapper.updateUser(userId,studentId,password,userName,realName,sex,birthday,enterSchoolTime,major,mobilePhone,email,
                selfImage,createTime,status,idolSum,fansSum);
    }

    //根据userId查询user
    @Override
    public User selectUserByUserId(String userId) {
        return userMapper.selectUserByUserId(userId);
    }

}

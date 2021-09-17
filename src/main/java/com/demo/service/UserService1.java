package com.demo.service;

import com.demo.pojo.user.User;

import java.sql.Date;
import java.sql.Timestamp;

public interface UserService1 {

    //根据studentId查询user
    User selectUserById(String studentId);

    //注册
    boolean insertUser(String userId,String studentId,String password,int status);

    //修改User信息
    boolean updateUser(String userId, String studentId, String password, String userName,
                       String realName, String sex, Date birthday, Date enterSchoolTime,
                       String major, String mobilePhone, String email,
                       String selfImage, Timestamp createTime, int status,
                       int idolSum, int fansSum);

    //根据userId查询user
    User selectUserByUserId(String userId);

}

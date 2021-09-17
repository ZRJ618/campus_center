package com.demo.service.impl;

import com.demo.exception.GlobalException;
import com.demo.mapper.UserMapper;
import com.demo.pojo.user.User;
import com.demo.pojo.user.UserModel;
import com.demo.service.UserService;
import com.demo.util.DateUtils;
import jdk.nashorn.internal.objects.Global;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public UserModel login(String studentId, String password) {
        UserModel login = userMapper.login(studentId, password);
        return login;
    }

    @Override
    public UserModel getUserModelById(String userId) {
        UserModel user = userMapper.getUserById(userId);
        return user;
    }

    @Override
    public boolean register(String studentId, String password, String userName, String realName, String mobilePhone,
                            String sex, String birthday, String enterSchoolTime, String major,
                            String email, String selfImage,String activationCode) {
        User userTest = userMapper.getUserByStudentId(studentId);
        if(userTest != null) {
            throw new GlobalException("500", "该学号已注册");
        }
        String userId = UUID.randomUUID().toString().replace("-", "");
        User user = new User();
        user.setStudentId(studentId);
        user.setPassword(password);
        user.setUserId(userId);
        user.setMobilePhone(mobilePhone);
        user.setRealName(realName);
        user.setUserName(userName);
        user.setEnterSchoolTime(enterSchoolTime);
        user.setBirthday(birthday);
        user.setSelfImage(selfImage);
        user.setSex(sex);
        user.setMajor(major);
        user.setEmail(email);
        user.setCreateTime(DateUtils.getDate());
        user.setModifyTime(DateUtils.getDate());
        user.setActivationCode(activationCode);
        Integer add = userMapper.addUser(user);
        return add == 1;
    }

    @Override
    public boolean updatePassword(String userId, String oldPassword, String newPassword) {
        UserModel user = userMapper.getUserByIdAndPass(userId, oldPassword);
        if(user == null){
            throw new GlobalException("500", "用户不存在");
        }
        Integer update = userMapper.updatePassword(userId, newPassword, DateUtils.getDate());
        return update == 1;
    }


}

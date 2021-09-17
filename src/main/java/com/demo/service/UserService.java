package com.demo.service;


import com.demo.pojo.user.UserModel;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserService {
    UserModel login(String studentId, String password);
    UserModel getUserModelById(String userId);
    boolean register(String studentId, String password, String userName,String mobilePhone,
                     String realName, String sex, String birthday, String enterSchoolTime,
                     String major, String email, String selfImage,String activationCode);
    boolean updatePassword(String userId, String oldPassword, String newPassword);


}

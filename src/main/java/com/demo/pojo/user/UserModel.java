package com.demo.pojo.user;

import lombok.Data;

@Data
public class UserModel {
    //用户id
    private String userId;
    //学号
    private String studentId;
    private String userName;//放入了token
    private String sex;//放入了token
    private String major;//放入了token
    private String mobilePhone;
    private String birthday;
    private String email;
    private String selfImage;
    private String token;
    private int status;
    private int idolSum;
    private int fansSum;
    private String activationCode;
}

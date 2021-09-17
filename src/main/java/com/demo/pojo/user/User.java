package com.demo.pojo.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/* *
 * @description: 用户表
 * @author: lazy
 * @dateTime: 2021/3/20 15:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //用户id
    private String userId;//放入token
    //学号
    private String studentId;
    //密码
    private String password;
    private String userName;
    private String realName;
    private String sex;
    private String birthday;//插入时用sql.date类型
    private String enterSchoolTime;//插入时用sql.date类型
    private String major;
    private String mobilePhone;
    private String email;
    private String selfImage;
    private int status;
    //创建日期
    private String createTime;
    private int idolSum;
    private int fansSum;
    private String activationCode;//激活码（用于注册时激活）
    //修改日期
    private String modifyTime;
    private String deleted;
}

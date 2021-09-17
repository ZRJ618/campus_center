package com.demo.pojo.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/* *
 * @description: 学生表(对应数据库)
 * @author: lazy
 * @dateTime: 2021/3/20 15:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    //用户id
    private String userId;
    //学号
    private String StudentId;
    //用户名
    private String userName;
    //真实姓名
    private String userRealName;
    //性别
    private String sex;
    //年级
    private String grade;
    //专业
    private String major;
    //权限id
    private String powerId;
    //email
    private String email;
    //头像路径
    private String HeadPortrait;
    //一寸照片路径
    private String inchPhoto;
    //创建时间
    private String createTime;
    //修改时间
    private String modifyTime;
}

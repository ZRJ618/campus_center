package com.demo.pojo.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/* *
 * @description: 学生表(model)
 * @author: lazy
 * @dateTime: 2021/3/20 15:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentModel {
    //学号
    private String StudentId;
    //用户名
    private String UserName;
    //真实姓名
    private String UserRealName;
    //性别
    private String sex;
    //年级
    private String grade;
    //专业
    private String major;
    //email
    private String email;
    //头像路径
    private String HeadPortrait;
    //一寸照片路径
    private String inchPhoto;
}

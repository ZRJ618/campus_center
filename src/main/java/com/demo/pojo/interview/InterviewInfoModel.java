package com.demo.pojo.interview;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* *
 * @description: 面试表信息类(model)
 * @author: lazy
 * @dateTime: 2021/3/20 15:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterviewInfoModel {
    //面试表id
    private String interviewId;
    //userId
    private String userId;
    //部门名
    private String departmentName;
    //志愿等级
    private Integer rank;
    //对部门的认识
    private String know;
    //个人优点
    private String advantage;
    //个人缺点
    private String disadvantage;
    //真实姓名
    private String userRealName;
    //一寸照片
    private String inchPhoto;
    //专业
    private String major;
    //性别
    private String sex;

}

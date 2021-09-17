package com.demo.pojo.interview;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/* *
 * @description: 面试表信息类(对应数据库)
 * @author: lazy
 * @dateTime: 2021/3/20 15:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterviewInfo{
    //面试表id
    private String interviewId;
    //学号
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
    //创建时间
    private String createTime;
    //修改时间
    private String modifyTime;
}


package com.demo.pojo.introduce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* *
 * @description: 部门负责人信息简介
 * @author: lazy
 * @dateTime: 2021/3/20 15:56
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChargeMan {
    //年级
    private String grade;
    //专业
    private String major;
    //性别
    private String sex;
    //一寸照片
    private String inchPhoto;
    //真实姓名
    private String userRealName;
}

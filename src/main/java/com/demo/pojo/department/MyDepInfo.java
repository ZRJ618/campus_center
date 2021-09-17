package com.demo.pojo.department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyDepInfo {
    //部门id
    private String departmentId;
    //部门名
    private String departmentName;
    //部门人数
    private String peopleNum;
    //职位
    private String position;
    //父级名
    private String parentName;
    //部门图片字符串
    private String depImage;
    //部门图片列表
    private List<String> depImageList;
    //部门简介
    private String briefIntroduce;
}

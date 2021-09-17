package com.demo.pojo.department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/* *
 * @description: 部门类
 * @author: lazy
 * @dateTime: 2021/3/20 15:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    //部门id
    private String departmentId;
    //部门名称
    private String departmentName;
    //父级部门id
    private String parentId;
    //父级部门名
    private String parentName;
    //部门等级
    private String departmentGrade;
    //创建时间
    private String createTime;
    //修改时间
    private String modifyTime;

}

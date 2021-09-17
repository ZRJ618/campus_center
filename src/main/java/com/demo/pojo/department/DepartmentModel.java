package com.demo.pojo.department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* *
 * @description: 缩略部门类
 * @params:
 * @return:
 * @author: lazy
 * @dateTime: 2021/3/20 15:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentModel {
    //部门id
    private String departmentId;
    //部门名称
    private String departmentName;
    //父级部门名
    private String parentName;

}

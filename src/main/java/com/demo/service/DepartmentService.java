package com.demo.service;

import com.demo.pojo.department.DepartmentModel;
import com.demo.pojo.department.MyDepInfo;

import java.util.List;

public interface DepartmentService {

    /* *
     * @description: 添加部门
     * @params: [depName 部门名, parentId 部门id, parentName 父级部门名, departmentGrade 部门等级]
     * @return: boolean
     * @author: lazy
     * @dateTime: 2021/4/1 16:34
     */
    boolean addDepartment(String depName, String parentId, String parentName, String departmentGrade);

    /* *
     * @description: 获取部门列表
     * @params: [departmentGrade 部门等级, parentId 部门id]
     * @return: java.util.List<com.demo.pojo.DepartmentModel>
     * @author: lazy
     * @dateTime: 2021/4/1 16:34
     */
    List<DepartmentModel> getDepList(String departmentGrade, String parentId);

/*    boolean addDepartment(String departmentName, String parentDepartmentName);

    boolean addParentDepartment(String departmentName);*/

    /* *
     * @description: 更新部门信息
     * @params: [departmentId 部门id, departmentName 部门名, parentId 父级部门id, parentName 父级部门名, departmentGrade 部门等级]
     * @return: boolean
     * @author: lazy
     * @dateTime: 2021/4/1 23:02
     */
    boolean updateDepartment(String departmentId, String departmentName, String  parentId,String  parentName,String  departmentGrade);

/*    PageResult getDepartmentList(String parentDepartmentName, Integer pageNum);*/

    boolean deleteDepartment(String departmentName);

    MyDepInfo getMyDep(String userId);
}

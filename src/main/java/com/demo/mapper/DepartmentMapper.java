package com.demo.mapper;

import com.demo.pojo.department.Department;
import com.demo.pojo.department.DepartmentModel;
import com.demo.pojo.department.MyDepInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DepartmentMapper {

    /* *
     * @description: 添加部门
     * @params: [department 部门类]
     * @return: java.lang.Integer
     * @author: lazy
     * @dateTime: 2021/4/1 16:01
     */
    Integer addDepartment(Department department);

    /* *
     * @description: 通过部门名字查询部门
     * @params: [departmentName]
     * @return: com.demo.pojo.Department
     * @author: lazy
     * @dateTime: 2021/4/1 16:01
     */
    Department getDepByName(String departmentName);

    /* *
     * @description: 通过部门等级查询部门
     * @params: [departmentGrade]
     * @return: java.util.List<com.demo.pojo.DepartmentModel>
     * @author: lazy
     * @dateTime: 2021/4/1 21:38
     */
    List<DepartmentModel> getDepListByGrade(String departmentGrade);

    /* *
     * @description: 通过部门id查询部门列表
     * @params: [departmentId]
     * @return: com.demo.pojo.Department
     * @author: lazy
     * @dateTime: 2021/4/1 21:39
     */
    Department getDepById(String departmentId);

    /* *
     * @description: 通过部门父级id查询部门列表
     * @params: [parentId]
     * @return: java.util.List<com.demo.pojo.DepartmentModel>
     * @author: lazy
     * @dateTime: 2021/4/1 21:38
     */
    List<DepartmentModel> getDepListByParentId(String parentId);


    DepartmentModel getDepartmentModelByName(String departmentName);


    /* *
     * @description: 更新部门信息
     * @params: [department]
     * @return: java.lang.Integer
     * @author: lazy
     * @dateTime: 2021/4/1 21:39
     */
    Integer updateDepartment(Department department);

    /* *
     * @description: 删除部门信息
     * @params: [departmentId, modifyTime]
     * @return: java.lang.Integer
     * @author: lazy
     * @dateTime: 2021/4/1 21:39
     */
    Integer deleteDepartment(String departmentId, String modifyTime);

    /* *
     * @description: 通过部门名查询部门id
     * @params: [departmentName]
     * @return: java.lang.String
     * @author: lazy
     * @dateTime: 2021/4/1 21:40
     */
    String getIdByDepartmentName(String departmentName);

    Integer addPeopleNum(String departmentId);

    MyDepInfo getMyDep(String userId);
}

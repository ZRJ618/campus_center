package com.demo.service.impl;

import com.demo.exception.GlobalException;
import com.demo.mapper.DepartmentMapper;
import com.demo.pojo.department.Department;
import com.demo.pojo.department.DepartmentModel;

import com.demo.pojo.department.MyDepInfo;
import com.demo.service.DepartmentService;
import com.demo.util.DateUtils;
import com.demo.util.ImageUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    DepartmentMapper departmentMapper;

   /* @Override
    public boolean addDepartment(String departmentName, String parentDepartmentName) {
        //子部门存在，则无法创建
        DepartmentModel sonDepartment = departmentMapper.getDepartmentModelByName(departmentName);
        if(sonDepartment != null){
            throw new GlobalException("500", "子部门已存在");
        }
        //父部门不存在，则无法创建
        DepartmentModel parentDepartment = departmentMapper.getDepartmentModelByName(parentDepartmentName);
        if(parentDepartment == null){
            throw new GlobalException("500", "父级部门未找到");
        }
        Department department = new Department();
        department.setDepartmentId(UUID.randomUUID().toString());
        department.setDepartmentName(departmentName);
        department.setParentId(parentDepartment.getDepartmentId());
        department.setParentName(parentDepartmentName);
        department.setCreateTime(DateUtils.getDate());
        department.setModifyTime(DateUtils.getDate());
        Integer add = departmentMapper.addDepartment(department);
        return add == 1;
    }

    @Override
    public boolean addParentDepartment(String departmentName) {
        DepartmentModel oldDepartment = departmentMapper.getDepartmentModelByName(departmentName);
        if(oldDepartment != null){
            throw new GlobalException("500", "该部门已存在");
        }
        Department department = new Department();
        department.setDepartmentId(UUID.randomUUID().toString());
        department.setDepartmentName(departmentName);
        department.setParentName("无父部门");
        department.setParentId("0");
        department.setCreateTime(DateUtils.getDate());
        department.setModifyTime(DateUtils.getDate());
        Integer add = departmentMapper.addDepartment(department);
        return add == 1;
    }*/

    /* *
     * @description: 添加部门信息
     * @params: [depName 部门名, parentId 父级id, parentName 父级部门名]
     * @return: boolean
     * @author: lazy
     * @dateTime: 2021/4/1 16:04
     */
    public boolean addDepartment(String depName, String parentId, String parentName, String  departmentGrade) {
        Department oldDep = departmentMapper.getDepByName(depName);
        if(oldDep != null){
            throw new GlobalException("500", "该部门已存在");
        }
        Department department = new Department();
        department.setDepartmentId(UUID.randomUUID().toString());
        department.setDepartmentName(depName);
        department.setParentId(parentId);
        department.setParentName(parentName);
        department.setDepartmentGrade(departmentGrade);
        department.setCreateTime(DateUtils.getDate());
        department.setModifyTime(DateUtils.getDate());
        Integer add = departmentMapper.addDepartment(department);
        return add == 1;
    }

    @Override
    public List<DepartmentModel> getDepList(String departmentGrade, String parentId) {
        List<DepartmentModel> depList;
        if(departmentGrade != null) {
            depList = departmentMapper.getDepListByGrade(departmentGrade);
        }else {
            depList = departmentMapper.getDepListByParentId(parentId);
        }
        if(depList.size() == 0 || depList == null) {
            throw new GlobalException("未查询到部门");
        }
        return depList;
    }

    @Override
    public boolean updateDepartment(String departmentId, String departmentName, String parentId, String parentName, String  departmentGrade) {
        Department department = departmentMapper.getDepById(departmentId);
        if(department == null){
            throw new GlobalException("500", "修改部门名不存在");
        }
/*        if(departmentName != null){
            DepartmentModel departmentModel = departmentMapper.getDepartmentModelByName(departmentName);
            if(departmentModel != null){
                throw new GlobalException("500", "修改部门名已存在");
            }
            department.setDepartmentName(departmentName);
        }*/
/*        if(parentId != null && !department.getParentId().equals(parentId)){
            DepartmentModel parentDepartment = departmentMapper.getDepartmentModelByName(parentId);
            if(parentDepartment == null){
                throw new GlobalException("500", "父级部门不存在，请选择正确的父级部门");
            }
            department.setParentName(parentDepartment.getParentName());
        }*/


        if(departmentName != null && !department.getDepartmentName().equals(departmentName)) {
            department.setDepartmentName(departmentName);
        }
        if(parentId != null && !department.getParentId().equals(parentId)) {
            department.setParentId(parentId);
        }
        if(parentName != null && !department.getParentName().equals(parentName)) {
            department.setParentName(parentName);
        }
        if(departmentGrade != null && !department.getDepartmentGrade().equals(departmentGrade)) {
            department.setDepartmentGrade(departmentGrade);
        }

        department.setModifyTime(DateUtils.getDate());
        Integer update = departmentMapper.updateDepartment(department);
        return update == 1;
    }

/*    @Override
    public PageResult getDepartmentList(String parentDepartmentName, Integer pageNum) {
        DepartmentModel department = departmentMapper.getDepartmentModelByName(parentDepartmentName);
        if(department == null){
            throw new GlobalException("500", "父级部门未找到");
        }
        PageHelper.startPage(pageNum, 10);
        List<DepartmentModel> departmentList = departmentMapper.getDepartmentList(department.getDepartmentId());
        if(departmentList == null){
            throw new GlobalException("500", "未查询到部门列表");
        }
        PageInfo<DepartmentModel> pageInfo = new PageInfo<>(departmentList);
        PageResult<DepartmentModel> pageResult = PageUtils.packPage(pageInfo);
        return pageResult;
    }*/

    @Override
    public boolean deleteDepartment(String departmentId) {
        Department department = departmentMapper.getDepById(departmentId);
        if(department == null){
            throw new GlobalException("500", "该部门不存在，无法删除");
        }
        Integer delete = departmentMapper.deleteDepartment(departmentId, DateUtils.getDate());
        return delete == 1;
    }

    @Override
    public MyDepInfo getMyDep(String userId) {
        MyDepInfo myDep = departmentMapper.getMyDep(userId);
        if(myDep == null) {
            throw new GlobalException("500", "未加入部门，请先加入部门");
        }
        if(myDep.getDepImage() != null) {
            myDep.setDepImageList(ImageUtils.StringToList(myDep.getDepImage()));
        }

        return myDep;
    }

/*    *//* *
     * @description: 通过部门名获取部门id
     * @params: [departmentName]
     * @return: java.lang.String
     * @author: lazy
     * @dateTime: 2021/3/20 16:19
     *//*
    @Override
    public String getIdByDepartmentName(String departmentName) {
        String departmentId = departmentMapper.getIdByDepartmentName(departmentName);
        return departmentId;
    }*/
}

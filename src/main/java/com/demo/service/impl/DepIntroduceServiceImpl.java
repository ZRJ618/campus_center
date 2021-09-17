package com.demo.service.impl;

import com.demo.exception.GlobalException;
import com.demo.mapper.DepIntroduceMapper;
import com.demo.mapper.DepartmentMapper;
import com.demo.mapper.StudentMapper;
import com.demo.mapper.UserMapper;
import com.demo.pojo.department.Department;
import com.demo.pojo.introduce.ChargeMan;
import com.demo.pojo.introduce.DepIntroduceModel;
import com.demo.pojo.introduce.DepIntroducePojo;
import com.demo.service.DepIntroduceService;
import com.demo.util.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepIntroduceServiceImpl implements DepIntroduceService {
    @Resource
    DepIntroduceMapper depIntroduceMapper;
    @Resource
    DepartmentMapper departmentMapper;
    @Resource
    UserMapper userMapper;

    @Override
    public boolean addDepIntroduce(String departmentName, String briefIntroduce, String workIntroduce,
                                      String recruit, String depImage, String chargeOne, String chargeTow, String chargeThree) {
        //检查负责人是否存在
        if(userMapper.getUserById(chargeOne) == null ||
                userMapper.getUserById(chargeTow) == null ||
                userMapper.getUserById(chargeThree) == null) {
            throw new GlobalException("500", "负责人不存在");
        }
        String departmentId = checkDepId(departmentName);
        Department depById = departmentMapper.getDepById(departmentId);
        if(depById != null) {
            throw new GlobalException("500", "该部门信息介绍已添加");
        }
        DepIntroducePojo depIntroduce = new DepIntroducePojo();
        depIntroduce.setDepartmentId(departmentId);
        depIntroduce.setBriefIntroduce(briefIntroduce);
        depIntroduce.setWorkIntroduce(workIntroduce);
        depIntroduce.setRecruit(recruit);
        depIntroduce.setDepImage(depImage);
        depIntroduce.setChargeOne(chargeOne);
        depIntroduce.setChargeTwo(chargeTow);
        depIntroduce.setChargeThree(chargeThree);
        depIntroduce.setCreateTime(DateUtils.getDate());
        depIntroduce.setModifyTime(DateUtils.getDate());
        Integer add = depIntroduceMapper.addDepIntroduce(depIntroduce);
        return add == 1;
    }

    @Override
    public boolean updateCharge(String departmentName, String chargeId, String chargeType) {
        String departmentId = checkDepId(departmentName);
        if(depIntroduceMapper.getDepById(departmentId) == null) {
            throw new GlobalException("500", "未添加部门简介");
        }
        if(userMapper.getUserById(chargeId) == null) {
            throw new GlobalException("500", "负责人不存在");
        }
        Integer update = 0;
        if(chargeType == "第一负责人") {
            update = depIntroduceMapper.updateChargeOne(chargeId, departmentId, DateUtils.getDate());
        }else if(chargeType == "第二负责人") {
            update = depIntroduceMapper.updateChargeTow(chargeId, departmentId, DateUtils.getDate());
        }else if(chargeType == "第三负责人"){
            update = depIntroduceMapper.updateChargeThree(chargeId, departmentId, DateUtils.getDate());
        }
        return update == 1;
    }

    @Override
    public boolean updateDepIntroduce(String departmentName, String briefIntroduce,
                                      String workIntroduce, String recruit, String depImage) {
        String departmentId = checkDepId(departmentName);
        DepIntroducePojo depIntroducePojo = depIntroduceMapper.getDepById(departmentId);
        if(briefIntroduce != null && !depIntroducePojo.getBriefIntroduce().equals(briefIntroduce)) {
            depIntroducePojo.setBriefIntroduce(briefIntroduce);
        }
        if(workIntroduce != null && !depIntroducePojo.getWorkIntroduce().equals(workIntroduce)) {
            depIntroducePojo.setWorkIntroduce(workIntroduce);
        }
        if(recruit != null && !depIntroducePojo.getRecruit().equals(recruit)) {
            depIntroducePojo.setRecruit(recruit);
        }
        if(depImage != null && !depIntroducePojo.getDepImage().equals(depImage)) {
            depIntroducePojo.setDepImage(depImage);
        }
        depIntroducePojo.setModifyTime(DateUtils.getDate());
        Integer update = depIntroduceMapper.updateDepIntroduce(depIntroducePojo);
        return update == 1;
    }

    @Override
    public DepIntroduceModel showDepInfo(String departmentName) {
        DepIntroduceModel model = new DepIntroduceModel();
        String departmentId = checkDepId(departmentName);
        DepIntroducePojo pojo = depIntroduceMapper.getDepById(departmentId);
        if(pojo == null) {
            throw new GlobalException("500", "未查询到部门简介，请先添加");
        }
        model.setDepartmentName(departmentName);
        model.setBriefIntroduce(pojo.getBriefIntroduce());
        model.setRecruit(pojo.getRecruit());
        model.setWorkIntroduce(pojo.getWorkIntroduce());
        List<ChargeMan> list = new ArrayList<>();
        list.add(userMapper.getChargeMan(pojo.getChargeOne()));
        list.add(userMapper.getChargeMan(pojo.getChargeTwo()));
        list.add(userMapper.getChargeMan(pojo.getChargeThree()));
        model.setChargeManList(list);
        return model;
    }

    @Override
    public boolean deleteDepInfo(String departmentName) {
        String departmentId = checkDepId(departmentName);
        Integer delete = depIntroduceMapper.deleteDepInfo(departmentId);
        return delete == 1;
    }

    private String checkDepId(String departmentName) {
        String departmentId = departmentMapper.getIdByDepartmentName(departmentName);
        if(departmentId == null) {
            throw new GlobalException("500", "部门不存在");
        }
        return departmentId;
    }
}

package com.demo.service.impl;

import com.demo.exception.GlobalException;
import com.demo.mapper.DepMemberMapper;
import com.demo.mapper.DepartmentMapper;
import com.demo.pojo.department.DepMember;
import com.demo.service.DepMemberService;
import com.demo.util.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class DepMemberServiceImpl implements DepMemberService {

    @Resource
    private DepMemberMapper depMemberMapper;
    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public boolean joinDepartment(String departmentId, String departmentName, String userId, String position) {
        DepMember addDep = depMemberMapper.isAddDep(departmentId, userId);
        if(addDep != null) {
            throw new GlobalException("500", "已加入,请勿连续添加");
        }
        DepMember depMember = new DepMember();
        String memberId = UUID.randomUUID().toString().replace("-", "");
        depMember.setMemberId(memberId);
        depMember.setDepartmentId(departmentId);
        depMember.setDepartmentName(departmentName);
        depMember.setUserId(userId);
        depMember.setPosition(position);
        depMember.setCreateTime(DateUtils.getDate());
        depMember.setModifyTime(DateUtils.getDate());
        Integer addMem = depMemberMapper.addDepMember(depMember);
        Integer addNum = departmentMapper.addPeopleNum(departmentId);
        return addMem == 1 && addNum == 1;
    }

    @Override
    public boolean updateMemInfo(String departmentId, String userId, boolean deleted, boolean isOld) {
        Integer update = depMemberMapper.updateMemInfo(departmentId, userId, deleted, isOld);
        return update == 1;
    }
}

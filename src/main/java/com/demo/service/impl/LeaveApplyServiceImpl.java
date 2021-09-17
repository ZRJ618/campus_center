package com.demo.service.impl;


import com.demo.exception.GlobalException;
import com.demo.mapper.DepMemberMapper;
import com.demo.mapper.DepartmentMapper;
import com.demo.mapper.LeaveApplyMapper;
import com.demo.mapper.UserMapper;
import com.demo.pojo.PageResult;
import com.demo.pojo.department.DepMember;
import com.demo.pojo.department.Department;
import com.demo.pojo.leaveApply.LeaveApply;
import com.demo.pojo.leaveApply.LeaveApplyModel;
import com.demo.pojo.user.UserModel;
import com.demo.service.LeaveApplyService;
import com.demo.util.DateUtils;
import com.demo.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class LeaveApplyServiceImpl implements LeaveApplyService {

    @Resource
    LeaveApplyMapper leaveApplyMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    DepMemberMapper depMemberMapper;

    @Value("${page.pageSize}")
    Integer pageSize;

    @Override
    public boolean addApply(String userId, String leaveType, String startTime, String endTime,
                            String reason, String departmentId, String applyUser) {
        UserModel user = userMapper.getUserById(userId);
        if(user == null) {
            throw new GlobalException("400","审批人不存在，请重新选择");
        }
/*        System.out.println(userId);
        System.out.println(departmentId);*/
        DepMember isDep = depMemberMapper.isAddDep(departmentId, userId);
        if(isDep == null) {
            throw new GlobalException("未加入该组织，无法提交审批");
        }
        LeaveApply leaveApply = new LeaveApply();
        leaveApply.setApplyId(UUID.randomUUID().toString().replace("-", ""));
        leaveApply.setUserId(userId);
        leaveApply.setLeaveType(leaveType);
        leaveApply.setStartTime(startTime);
        leaveApply.setEndTime(endTime);
        leaveApply.setReason(reason);
        leaveApply.setDepartmentId(departmentId);
        leaveApply.setApplyUser(applyUser);
        leaveApply.setCreateTime(DateUtils.getDate());
        leaveApply.setModifyTime(DateUtils.getDate());
        Integer add = leaveApplyMapper.addApply(leaveApply);
        return add == 1;
    }

    @Override
    public boolean updateApply(String applyId, Integer applyStatus, String leaveType, String startTime,
                               String endTime, String reason, String applyUser) {
        if(applyStatus != null) {
            Integer update = leaveApplyMapper.setApply(applyId, applyStatus);
            return update == 1;
        }else {
            LeaveApply apply = leaveApplyMapper.getApplyById(applyId);
            if(leaveType != null && !apply.getLeaveType().equals(leaveType)) {
                apply.setLeaveType(leaveType);
            }
            if(startTime != null && !apply.getStartTime().equals(startTime)) {
                apply.setStartTime(startTime);
            }
            if(endTime != null && !apply.getEndTime().equals(endTime)) {
                apply.setEndTime(endTime);
            }
            if(reason != null && !apply.getReason().equals(reason)) {
                apply.setReason(reason);
            }
            if(applyUser != null && !apply.getApplyUser().equals(applyUser)) {
                apply.setApplyUser(applyUser);
            }
            Integer update = leaveApplyMapper.updateApply(apply);
            return update == 1;
        }

    }

    @Override
    public boolean deleteApply(String applyId) {
        Integer delete = leaveApplyMapper.deleteApply(applyId);
        return delete == 1;
    }

    @Override
    public PageResult<LeaveApplyModel> getApplyList(String leaveType, Integer applyStatus,
                                                    String userId, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaveApplyModel> applyList = leaveApplyMapper.getApplyList(leaveType, applyStatus, userId);
        PageInfo<LeaveApplyModel> pageInfo = new PageInfo<>(applyList);
        PageResult<LeaveApplyModel> pageResult = PageUtils.packPage(pageInfo);
        return pageResult;
    }
}

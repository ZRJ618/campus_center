package com.demo.service.impl;


import com.demo.exception.GlobalException;
import com.demo.mapper.DepartmentMapper;
import com.demo.mapper.InterviewTimeMapper;
import com.demo.pojo.department.DepartmentModel;
import com.demo.pojo.interview.InterviewTime;
import com.demo.pojo.interview.InterviewTimeModel;
import com.demo.service.InterviewTimeService;
import com.demo.util.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class InterviewTimeServiceImpl implements InterviewTimeService {
    @Resource
    InterviewTimeMapper interviewTimeMapper;
    @Resource
    DepartmentMapper departmentMapper;
    @Override
    public boolean addInterviewTimeInfo(String studentId, String departmentName, String startTime, String endTime) {
        DepartmentModel departmentModel = departmentMapper.getDepartmentModelByName(departmentName);
        if(departmentModel == null){
            throw new GlobalException("500", "部门不存在，无法添加面试信息");
        }
        InterviewTime interviewTime1 = interviewTimeMapper.checkInterviewInfo(studentId, startTime);
        if(interviewTime1 != null){
            throw new GlobalException("500", "该成员的" + departmentName + "部门面试时间以确定");
        }
        InterviewTime interviewTime = new InterviewTime();
        interviewTime.setTimeId(UUID.randomUUID().toString());
        interviewTime.setStudentId(studentId);
        interviewTime.setDepartmentName(departmentName);
        interviewTime.setStartTime(startTime);
        interviewTime.setEndTime(endTime);
        interviewTime.setCreateTime(DateUtils.getDate());
        interviewTime.setModifyTime(DateUtils.getDate());
        Integer add = interviewTimeMapper.addInterviewTimeMapper(interviewTime);
        return add == 1;
    }

    @Override
    public boolean deleteInterviewInfo(String studentId, String departmentName) {
        InterviewTime interviewTime = interviewTimeMapper.checkInterviewInfo(studentId, departmentName);
        if(interviewTime == null){
            throw new GlobalException("500", departmentName + "  未安排面试时间");
        }
        Integer delete = interviewTimeMapper.deleteInterviewInfo(studentId, departmentName, DateUtils.getDate());
        return delete == 1;
    }

    @Override
    public InterviewTimeModel getInterviewInfo(String studentId) {
        InterviewTimeModel interviewInfo = interviewTimeMapper.getInterviewInfo(studentId);
        if(interviewInfo == null){
            throw new GlobalException("500", "该用户面试时间未定");
        }
        return interviewInfo;
    }

    @Override
    public boolean updateInterviewTime(String timeId, String departmentName, String startTime, String endTime) {
        InterviewTime interview= interviewTimeMapper.getInterviewByTimeId(timeId);
        if(interview == null){
            throw new GlobalException("500", "该面试时间不存在");
        }
        if(!interview.getDepartmentName().equals(departmentName) && departmentName != null){
            interview.setDepartmentName(departmentName);
        }
        if(!interview.getStartTime().equals(startTime) && startTime != null){
            interview.setStartTime(startTime);
        }
        if(!interview.getEndTime().equals(endTime) && endTime != null){
            interview.setEndTime(endTime);
        }
        interview.setModifyTime(DateUtils.getDate());
        Integer update = interviewTimeMapper.updateInterview(interview);
        return update == 1;
    }
}

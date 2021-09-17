package com.demo.service.impl;

import com.demo.exception.GlobalException;
import com.demo.mapper.DepartmentMapper;
import com.demo.mapper.InterviewInfoMapper;
import com.demo.mapper.StudentMapper;
import com.demo.pojo.*;
import com.demo.pojo.department.Department;
import com.demo.pojo.department.DepartmentModel;
import com.demo.pojo.interview.InterviewInfo;
import com.demo.pojo.interview.InterviewInfoModel;
import com.demo.pojo.user.StudentModel;
import com.demo.service.InterviewInfoService;
import com.demo.util.DateUtils;
import com.demo.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class InterviewInfoServiceImpl implements InterviewInfoService {

    @Resource
    InterviewInfoMapper interviewInfoMapper;
    @Resource
    DepartmentMapper departmentMapper;
    @Resource
    StudentMapper studentMapper;

    @Override
    public boolean addInterviewInfo(InterviewInfo interviewInfo, String departmentName) {
        Department depByName = departmentMapper.getDepByName(departmentName);
        if(depByName == null){
            throw new GlobalException("500", "部门不存在");
        }
        interviewInfo.setDepartmentName(departmentName);
        interviewInfo.setCreateTime(DateUtils.getDate());
        interviewInfo.setModifyTime(DateUtils.getDate());
        interviewInfo.setInterviewId(UUID.randomUUID().toString());
        Integer add = interviewInfoMapper.addInterviewInfo(interviewInfo);
        return add == 1;
    }

    @Override
    public List<InterviewInfoModel> getPersonalInterviewInfo(String userId) {
        List<InterviewInfoModel> interviewInfo = interviewInfoMapper.getPersonalInterviewInfo(userId);
        if(interviewInfo.size() == 0 || interviewInfo == null){
            throw new GlobalException("500", "该用户还未填写面试单");
        }
        return interviewInfo;
    }
    @Override
    public PageResult<InterviewInfoModel> getDepartmentInterviewInfo(String departmentName, Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<InterviewInfoModel> interviewListByDepartmentName = interviewInfoMapper.getInterviewListByDepartmentName(departmentName);
        if(interviewListByDepartmentName == null){
            throw new GlobalException("500", "该部门的所有面试时间未定");
        }
        PageInfo<InterviewInfoModel> pageInfo = new PageInfo<>(interviewListByDepartmentName);
        PageResult<InterviewInfoModel> pageResult = PageUtils.packPage(pageInfo);
        return pageResult;
    }

    @Override
    public boolean deleteInterviewInfo(String departmentName, String userId) {
        InterviewInfo interviewInfo = interviewInfoMapper.getInterviewInfoByNameAndId(departmentName, userId);
        if(interviewInfo == null){
            throw new GlobalException("500", "删除面试信息失败，该部门不存在");
        }
        Integer delete = interviewInfoMapper.deleteInterviewInfo(departmentName, userId, DateUtils.getDate());
        return delete == 1;
    }

    @Override
    public boolean updateInterviewInfo(String userId, String departmentName, Integer rank, String know, String advantage, String disAdvantage) {
        InterviewInfo interviewInfo = interviewInfoMapper.getInterviewInfoByNameAndId(departmentName, userId);
        if(interviewInfo == null){
            throw new GlobalException("500", "选择部门未填写面试单");
        }
        if(!interviewInfo.getDepartmentName().equals(departmentName) && departmentName != null){
            interviewInfo.setDepartmentName(departmentName);
        }
        if(!interviewInfo.getRank().equals(rank) && rank != null){
            interviewInfo.setRank(rank);
        }
        if(!interviewInfo.getKnow().equals(know) && know != null){
            interviewInfo.setKnow(know);
        }
        if(!interviewInfo.getAdvantage().equals(advantage) && advantage != null){
            interviewInfo.setAdvantage(advantage);
        }
        if(!interviewInfo.getDisadvantage().equals(disAdvantage) && disAdvantage != null){
            interviewInfo.setDisadvantage(disAdvantage);
        }
        interviewInfo.setModifyTime(DateUtils.getDate());
        Integer update = interviewInfoMapper.updateInterviewInfo(interviewInfo);
        return update == 1;
    }
}

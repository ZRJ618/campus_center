package com.demo.service;


import com.demo.pojo.interview.InterviewInfo;
import com.demo.pojo.interview.InterviewInfoModel;
import com.demo.pojo.PageResult;

import java.util.List;

public interface InterviewInfoService {

    boolean addInterviewInfo(InterviewInfo interviewInfo, String departmentName);

    List<InterviewInfoModel> getPersonalInterviewInfo(String userId);

    PageResult<InterviewInfoModel> getDepartmentInterviewInfo(String departmentName, Integer pageNum);

    boolean deleteInterviewInfo(String departmentName, String userId);

    boolean updateInterviewInfo(String userId, String departmentName, Integer rank, String know, String advantage, String disAdvantage);
}

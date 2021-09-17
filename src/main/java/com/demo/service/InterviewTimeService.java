package com.demo.service;

import com.demo.pojo.interview.InterviewTimeModel;

public interface InterviewTimeService {
    boolean addInterviewTimeInfo(String studentId, String departmentName, String startTime, String endTime);
    boolean deleteInterviewInfo(String studentId, String departmentName);
    InterviewTimeModel getInterviewInfo(String studentId);
    boolean updateInterviewTime(String timeId, String departmentName, String startTime, String endTime);
}

package com.demo.mapper;

import com.demo.pojo.interview.InterviewInfo;
import com.demo.pojo.interview.InterviewInfoModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface InterviewInfoMapper {

    Integer addInterviewInfo(InterviewInfo interviewInfo);

    List<InterviewInfoModel> getPersonalInterviewInfo(String userId);

    List<InterviewInfoModel> getInterviewListByDepartmentName(String departmentName);

    InterviewInfo getInterviewInfoByNameAndId(String departmentName, String userId);

    Integer updateInterviewInfo(InterviewInfo interviewInfo);

    Integer deleteInterviewInfo(String departmentName, String userId, String modifyTime);

}

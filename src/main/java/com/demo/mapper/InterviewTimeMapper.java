package com.demo.mapper;

import com.demo.pojo.interview.InterviewTime;
import com.demo.pojo.interview.InterviewTimeModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface InterviewTimeMapper {

    Integer addInterviewTimeMapper(InterviewTime interviewTime);
    InterviewTimeModel getInterviewInfo(String studentId);
    InterviewTime getInterviewByTimeId(String timeId);
    InterviewTime checkInterviewInfo(String studentId,String startTime);
    Integer updateInterview(InterviewTime interviewTime);
    Integer deleteInterviewInfo(String studentId, String departmentName, String modifyTime);
}

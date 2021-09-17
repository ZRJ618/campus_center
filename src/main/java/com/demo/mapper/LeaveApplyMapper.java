package com.demo.mapper;

import com.demo.pojo.leaveApply.LeaveApply;
import com.demo.pojo.leaveApply.LeaveApplyModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LeaveApplyMapper {

    Integer addApply(LeaveApply leaveApply);

    Integer updateApply(LeaveApply leaveApply);

    Integer setApply(String applyId, Integer applyStatus);

    Integer deleteApply(String applyId);

    LeaveApply getApplyById(String applyId);

    List<LeaveApplyModel> getApplyList(String leaveType, Integer applyStatus, String userId);
}

package com.demo.service;

import com.demo.pojo.PageResult;
import com.demo.pojo.leaveApply.LeaveApply;
import com.demo.pojo.leaveApply.LeaveApplyModel;

public interface LeaveApplyService {
    boolean addApply(String userId, String leaveType, String startTime, String endTime,
                     String reason, String departmentId, String applyUser);

    boolean updateApply(String applyId, Integer applyStatus, String leaveType, String startTime,
                        String endTime, String reason, String applyUser);

    boolean deleteApply(String applyId);

    PageResult<LeaveApplyModel> getApplyList(String leaveType, Integer applyStatus, String userId, Integer pageNum);
}

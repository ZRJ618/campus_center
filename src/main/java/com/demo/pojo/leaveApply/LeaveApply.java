package com.demo.pojo.leaveApply;

import lombok.Data;
@Data
public class LeaveApply {
    //审批id
    private String applyId;
    //用户id
    private String userId;
    //请假类型
    private String leaveType;
    //开始时间
    private String startTime;
    //结束时间
    private String endTime;
    //请假理由
    private String reason;
    //审批状态 0为审批中   1为审批通过  2为审批失败
    private Integer applyStatus;
    //审批部门id
    private String departmentId;
    //审批人
    private String applyUser;
    //创建时间
    private String createTime;
    //修改时间
    private String modifyTime;
}

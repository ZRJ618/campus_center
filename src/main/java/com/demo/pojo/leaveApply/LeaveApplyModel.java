package com.demo.pojo.leaveApply;

import lombok.Data;

@Data
public class LeaveApplyModel {

    //审批Id
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
    //审批状态 0为审批中   1为审批通过  2为审批失败  3为取消审批
    private Integer applyStatus;
    //审批人
    private String applyUser;
    //审批人姓名
    private String realName;
    //审批人头像
    private String selfImage;
}

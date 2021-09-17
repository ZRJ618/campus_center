package com.demo.pojo.department;

import lombok.Data;

@Data
public class DepCheck {
    private String DepCheckId;
    private String userId;
    private String realName;
    private String grade;
    private String positivePath;
    private String backPath;
    private String departmentId;
    //认证状态  0:未认证  1:认证成功 2:认证失败
    private Integer checkStatus;
    private String createTime;
    private String modifyTime;
}

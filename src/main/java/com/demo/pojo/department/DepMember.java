package com.demo.pojo.department;

import lombok.Data;

@Data
public class DepMember {
    private String memberId;
    private String departmentId;
    private String departmentName;
    private String position;
    private String userId;
    private String createTime;
    private String modifyTime;
}

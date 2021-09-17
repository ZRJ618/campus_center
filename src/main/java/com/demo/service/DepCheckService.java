package com.demo.service;

import com.demo.pojo.PageResult;
import com.demo.pojo.department.DepCheck;

public interface DepCheckService {
    boolean addDepCheck(String userId, String realName, String grade, String imagePath, String departmentId);

    PageResult<DepCheck> getDepCheckList(String studentId, String departmentName, boolean checkStatus, Integer pageNum);

    boolean setDepCheck(String depCheckId, String checkStatus);
}

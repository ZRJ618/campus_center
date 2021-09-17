package com.demo.service;

public interface DepMemberService {
    boolean joinDepartment(String departmentId, String departmentName, String userId, String position);

    boolean updateMemInfo(String departmentId, String userId, boolean deleted, boolean isOld);
}

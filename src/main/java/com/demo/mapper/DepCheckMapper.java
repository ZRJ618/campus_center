package com.demo.mapper;

import com.demo.pojo.department.DepCheck;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepCheckMapper {

    Integer addCheck(DepCheck depCheck);

    DepCheck isCheck(String userId, String departmentId);

    List<DepCheck> getCheckList(String studentId, String departmentName, boolean checkStatus);

    Integer setDepCheck(String depCheckId, String checkStatus);
}

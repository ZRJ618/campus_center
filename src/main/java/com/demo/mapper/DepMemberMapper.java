package com.demo.mapper;

import com.demo.pojo.department.DepMember;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DepMemberMapper {

    Integer addDepMember(DepMember depMember);

    Integer updateMemInfo(String departmentId, String userId, boolean deleted, boolean isOld);

    DepMember isAddDep(String departmentId, String userId);
}

package com.demo.service.impl;

import com.demo.exception.GlobalException;
import com.demo.mapper.DepCheckMapper;
import com.demo.pojo.PageResult;
import com.demo.pojo.department.DepCheck;
import com.demo.service.DepCheckService;
import com.demo.util.DateUtils;
import com.demo.util.ImageUtils;
import com.demo.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class DepCheckServiceImpl implements DepCheckService {

    @Resource
    DepCheckMapper depCheckMapper;

    @Value("${page.pageSize}")
    private Integer pageSize;

    @Override
    public boolean addDepCheck(String userId, String realName, String grade, String imagePath, String departmentId) {
        System.out.println(depCheckMapper.isCheck(userId, departmentId));
        if(depCheckMapper.isCheck(userId, departmentId) != null) {
            throw new GlobalException("500", "已申请");
        }
        DepCheck depCheck = new DepCheck();
        depCheck.setDepCheckId(UUID.randomUUID().toString().replace("-", ""));
        depCheck.setUserId(userId);
        depCheck.setRealName(realName);
        depCheck.setGrade(grade);
        depCheck.setDepartmentId(departmentId);
        List<String> list = ImageUtils.StringToList(imagePath);
        depCheck.setPositivePath(list.get(0));
        depCheck.setBackPath(list.get(1));
        depCheck.setCreateTime(DateUtils.getDate());
        depCheck.setModifyTime(DateUtils.getDate());
        Integer add = depCheckMapper.addCheck(depCheck);
        return add == 1;
    }

    @Override
    public PageResult<DepCheck> getDepCheckList(String studentId, String departmentName,
                                                boolean checkStatus, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<DepCheck> checkList = depCheckMapper.getCheckList(studentId, departmentName, checkStatus);
        if(checkList == null || checkList.size() == 0) {
            throw new GlobalException("500", "未查询到数据");
        }
        PageInfo<DepCheck> pageInfo = new PageInfo<>(checkList);
        PageResult<DepCheck> pageResult = PageUtils.packPage(pageInfo);
        return pageResult;
    }

    @Override
    public boolean setDepCheck(String depCheckId, String checkStatus) {
        Integer update = depCheckMapper.setDepCheck(depCheckId, checkStatus);
        return update == 1;
    }
}

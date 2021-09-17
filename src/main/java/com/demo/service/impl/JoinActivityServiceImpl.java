package com.demo.service.impl;

import com.demo.exception.GlobalException;
import com.demo.mapper.ActivityMapper;
import com.demo.mapper.JoinActivityMapper;
import com.demo.mapper.StudentMapper;
import com.demo.pojo.*;
import com.demo.pojo.activity.Activity;
import com.demo.pojo.activity.BActivity;
import com.demo.pojo.activity.JoinActivity;
import com.demo.pojo.user.StudentModel;
import com.demo.service.JoinActivityService;
import com.demo.util.DateUtils;
import com.demo.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class JoinActivityServiceImpl implements JoinActivityService {
    @Resource
    StudentMapper studentMapper;

    @Resource
    ActivityMapper activityMapper;

    @Resource
    JoinActivityMapper joinActivityMapper;

    @Value("${page.pageSize}")
    private Integer pageSize;


    /* *
     * @description: 参加活动
     * @params: [studentId 学号, activityId 活动id]
     * @return: boolean
     * @author: lazy
     * @dateTime: 2021/3/31 19:44
     */
    @Override
    public boolean addJoinActivity(String userId, String activityId) {
        JoinActivity joinActivity = new JoinActivity();
        joinActivity.setJoinId(UUID.randomUUID().toString().replace("-", ""));
       /* StudentModel student = studentMapper.getStudentModelById(userId);
        if(student == null){
            throw new GlobalException("500", "该用户不存在");
        }*/
        joinActivity.setUserId(userId);
        Activity activity= activityMapper.getActivityById(activityId);
        if(activity == null){
            throw new GlobalException("500", "该活动不存在");
        }
        if(activity.getJoinNum() >= activity.getTotalNum()){
            throw new GlobalException("500", "该活动已满人，无法添加");
        }
        JoinActivity checkActivity = joinActivityMapper.isJoinActivity(activityId, userId);
        if(checkActivity != null){
            throw new GlobalException("500", "已参加该活动");
        }
        joinActivity.setActivityId(activityId);
        joinActivity.setCreateTime(DateUtils.getDate());
        joinActivity.setModifyTime(DateUtils.getDate());
        Integer addJoin = joinActivityMapper.addJoinInfo(joinActivity);
        Integer addNum = activityMapper.addJoinNum(activityId, DateUtils.getDate());
        if(addJoin == 1 && addNum == 1) {
            return true;
        }
        return false;
    }


    /* *
     * @description: 取消活动
     * @params: [studentId 学号, activityId 活动id]
     * @return: boolean
     * @author: lazy
     * @dateTime: 2021/3/31 19:44
     */
    @Override
    public boolean cancelJoin(String userId, String activityId) {
        /*JoinActivity checkActivity = joinActivityMapper.isJoinActivity(activityId, userId);
        if(checkActivity == null){
            throw new GlobalException("500", "该用户与该活动未关联，无法删除");
        }*/
        Integer delete = joinActivityMapper.deleteJoin(activityId, userId);
        Integer subNum = activityMapper.subJoinNum(activityId, DateUtils.getDate());
        return delete == 1 && subNum == 1;
    }


    /* *
     * @description: 获取个人参加活动列表
     * @params: [userId 用户id, pageNum 页码]
     * @return: com.demo.pojo.PageResult<com.demo.pojo.BActivity>
     * @author: lazy
     * @dateTime: 2021/3/31 19:45
     */
    @Override
    public PageResult<BActivity> getJoinList(String userId, Integer pageNum) {
       /* StudentModel student = studentMapper.getStudentModelById(userId);
        if(student == null){
            throw new GlobalException("500", "该用户不存在");
        }*/
        PageHelper.startPage(pageNum, pageSize);
        List<Activity> activities = joinActivityMapper.getJoinList(userId);
        List<BActivity> list = new ArrayList<>();
        for(Activity activity: activities) {
            list.add(PageUtils.BActivityPage(activity));
        }
        PageInfo pageInfo = new PageInfo(activities);

        PageResult<BActivity> pageResult = PageUtils.packPageChange(pageInfo, list);
        return pageResult;
    }
}

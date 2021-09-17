package com.demo.service.impl;


import com.demo.exception.GlobalException;
import com.demo.mapper.ActivityMapper;
import com.demo.mapper.JoinActivityMapper;
import com.demo.mapper.StudentMapper;
import com.demo.mapper.UserMapper;
import com.demo.pojo.*;
import com.demo.pojo.activity.*;
import com.demo.pojo.user.User;
import com.demo.pojo.user.UserModel;
import com.demo.service.ActivityService;
import com.demo.util.DateUtils;
import com.demo.util.ImageUtils;
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
public class ActivityServiceImpl implements ActivityService {

    @Resource
    ActivityMapper activityMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    JoinActivityMapper joinActivityMapper;

    @Value("${page.pageSize}")
    private Integer pageSize;

    /* *
     * @description: 添加活动
     * @params: [activityTitle 活动标题, activityContent 活动内容, activityImage 活动图片, activityStartTime 活动开始时间,
     *  activityEndTime 活动结束时间, activityObject 活动招募对象, recruitStartTime 招募开始时间, recruitEndTime 招募结束时间,
     * totalNum 招募总人数, joinNum 参加人数, studentId 发布人学号, activityPlace 活动地点, activityAddress 详细地点, activityType 活动类型]
     * @return: boolean
     * @author: lazy
     * @dateTime: 2021/3/31 15:42
     */
    @Override
    public boolean addActivity(String activityTitle, String activityContent,
                            String activityImage, String activityStartTime, String activityEndTime,
                            String activityObject, String recruitStartTime, String recruitEndTime, Integer totalNum,
                            Integer joinNum, String userId, String activityPlace, String activityAddress,
                            String activityType) {
        Activity activity = new Activity();
        String realName = userMapper.getRealNameById(userId);
        activity.setActivityId(UUID.randomUUID().toString().replace("-", ""));
        activity.setActivityTitle(activityTitle);
        activity.setActivityContent(activityContent);
        activity.setActivityImage(activityImage);
        activity.setActivityStartTime(activityStartTime);
        activity.setActivityEndTime(activityEndTime);
        activity.setActivityObject(activityObject);
        activity.setRecruitStartTime(recruitStartTime);
        activity.setRecruitEndTime(recruitEndTime);
        activity.setTotalNum(totalNum);
        activity.setJoinNum(joinNum);
        activity.setUserId(userId);
        activity.setRealName(realName);
        activity.setActivityPlace(activityPlace);
        activity.setActivityAddress(activityAddress);
        activity.setActivityType(activityType);
        activity.setCreateTime(DateUtils.getDate());
        activity.setModifyTime(DateUtils.getDate());
        Integer insert = activityMapper.addActivity(activity);
        return insert == 1;
    }


    /* *
     * @description: 修改活动信息
     * @params: [activityTitle 活动标题, activityContent 活动内容, activityImage 活动图片, activityStartTime 活动开始时间,
     *  activityEndTime 活动结束时间, activityObject 活动招募对象, recruitStartTime 招募开始时间, recruitEndTime 招募结束时间,
     * totalNum 招募总人数, joinNum 参加人数, studentId 发布人学号, activityPlace 活动地点, activityAddress 详细地点, activityType 活动类型]
     * @return: boolean
     * @author: lazy
     * @dateTime: 2021/3/31 15:42
     */
    @Override
    public boolean updateActivity(String activityId, String activityTitle, String activityContent,
                               String activityStartTime, String activityEndTime, String activityObject,
                               String recruitStartTime, String recruitEndTime, Integer totalNum,
                               Integer joinNum, String activityPlace, String activityAddress, String activityType) {
        Activity activity = activityMapper.getActivityById(activityId);
        if(activity == null){
            throw new GlobalException("500", "该活动号不存在");
        }
        if(!activity.getActivityTitle().equals(activityTitle) && activityTitle != null){
            activity.setActivityTitle(activityTitle);
        }
        if(!activity.getActivityContent().equals(activityContent) && activityContent != null){
            activity.setActivityContent(activityContent);
        }
        if(!activity.getActivityStartTime().equals(activityStartTime) && activityStartTime != null){
            activity.setActivityStartTime(activityStartTime);
        }
        if(!activity.getActivityEndTime().equals(activityEndTime) && activityEndTime != null){
            activity.setActivityEndTime(activityEndTime);
        }
        if(!activity.getActivityObject().equals(activityObject) && activityObject != null){
            activity.setActivityObject(activityObject);
        }

        if(!activity.getRecruitStartTime().equals(recruitStartTime) && recruitStartTime != null){
            activity.setRecruitStartTime(recruitStartTime);
        }
        if(!activity.getRecruitEndTime().equals(recruitEndTime) && recruitEndTime != null){
            activity.setRecruitEndTime(recruitEndTime);
        }
        if(!activity.getTotalNum().equals(totalNum) && totalNum != null){
            activity.setTotalNum(totalNum);
        }

        if(!activity.getJoinNum().equals(joinNum) && joinNum != null){
            activity.setJoinNum(joinNum);
        }
        if(!activity.getActivityPlace().equals(activityPlace) && activityPlace != null){
            activity.setActivityPlace(activityPlace);
        }
        if(!activity.getActivityAddress().equals(activityAddress) && activityAddress != null){
            activity.setActivityAddress(activityAddress);
        }
        if(!activity.getActivityType().equals(activityType) && activityType != null){
            activity.setActivityType(activityType);
        }

        activity.setModifyTime(DateUtils.getDate());
        Integer update = activityMapper.updateActivity(activity);
        return update == 1;
    }

    /* *
     * @description: 删除活动
     * @params: [activityId 活动id]
     * @return: com.demo.pojo.DetailActivity
     * @author: lazy
     * @dateTime: 2021/3/31 15:41
     */
    @Override
    public boolean deletedActivity(String activityId) {
        Activity activityById = activityMapper.getActivityById(activityId);
        if(activityById == null){
            throw new GlobalException("500", "该活动不存在");
        }
        Integer delete = activityMapper.deleteActivity(activityId, DateUtils.getDate());
        return delete == 1;
    }


    /* *
     * @description: 查看活动详细内容
     * @params: [activityId 活动id]
     * @return: com.demo.pojo.DetailActivity
     * @author: lazy
     * @dateTime: 2021/3/31 19:02
     */
    @Override
    public DetailActivity getDetailActivity(String activityId, String userId) {
        DetailActivity detailActivity = activityMapper.getDetailActivityById(activityId);
        detailActivity.setImageList(ImageUtils.StringToList(detailActivity.getActivityImage()));
        JoinActivity joinActivity = joinActivityMapper.isJoinActivity(activityId, userId);

        detailActivity.setActivityStatus(PageUtils.getStatusDetail(detailActivity));
        if(joinActivity != null) {
            detailActivity.setJoin(true);
        }else {
            detailActivity.setJoin(false);
        }
        if(detailActivity == null){
            throw new GlobalException("500", "未查询到活动");
        }
        return detailActivity;
    }


    /* *
     * @description: 查看自己发布的活动
     * @params: [studentId 学号, pageNum 页码]
     * @return: com.demo.pojo.PageResult<com.demo.pojo.MyActivity>
     * @author: lazy
     * @dateTime: 2021/3/31 15:41
     */
    @Override
    public PageResult<MyActivity> getActivityPersonalList(String userId, Integer pageNum) {
        UserModel user = userMapper.getUserById(userId);
        if(user == null){
            throw new GlobalException("500", "该用户不存在");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Activity> activities = activityMapper.getActivityPersonalList(userId);

        if(activities == null || activities.size() == 0){
            throw new GlobalException("500", "该用户未发布活动");
        }
        List<MyActivity> myList = new ArrayList<>();
        for(Activity activity: activities) {
            myList.add(PageUtils.MyActivityPage(activity));
        }
        PageInfo<Activity> pageInfo = new PageInfo<>(activities);
        PageResult<MyActivity> pageResult = PageUtils.packPageChange(pageInfo, myList);
        return pageResult;
    }


    /* *
     * @description: 获取活动列表
     * @params: [activityTitle, 活动标题 activityObject 招募对象, activityStatus 活动状态, activityPlace 活动地点, pageNum 页码]
     * @return: com.demo.pojo.PageResult<com.demo.pojo.BActivity>
     * @author: lazy
     * @dateTime: 2021/3/29 19:59
     */
    @Override
    public PageResult<BActivity> getActivityList(
            String activityTitle,
            String activityObject,
            String activityStatus,
            String activityPlace,
            Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<Activity> chooseList = activityMapper.getActivityList(activityTitle, DateUtils.getDate(), activityStatus, activityPlace, activityObject);
        if(chooseList == null || chooseList.size() == 0){
            throw new GlobalException("500", "未搜搜到相关内容");
        }
        List<BActivity> myList = new ArrayList<>();
        for(Activity activity: chooseList) {
            myList.add(PageUtils.BActivityPage(activity));
        }
        PageInfo<Activity> pageInfo = new PageInfo<>(chooseList);
        PageResult<BActivity> pageResult = PageUtils.packPageChange(pageInfo, myList);
        return pageResult;
    }



}

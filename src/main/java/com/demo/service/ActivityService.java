package com.demo.service;

import com.demo.pojo.*;
import com.demo.pojo.activity.BActivity;
import com.demo.pojo.activity.DetailActivity;
import com.demo.pojo.activity.MyActivity;

public interface ActivityService {
    /* *
     * @description: 添加活动
     * @params: [activityTitle 活动标题, activityContent 活动内容, activityImage 活动图片, activityStartTime 活动开始时间,
     *  activityEndTime 活动结束时间, activityObject 活动招募对象, recruitStartTime 招募开始时间, recruitEndTime 招募结束时间,
     * totalNum 招募总人数, joinNum 参加人数, studentId 发布人学号, activityPlace 活动地点, activityAddress 详细地点, activityType 活动类型]
     * @return: boolean
     * @author: lazy
     * @dateTime: 2021/3/31 15:42
     */
    boolean addActivity(String activityTitle, String activityContent, String activityImage,
                     String activityStartTime, String activityEndTime, String activityObject, String recruitStartTime,
                     String recruitEndTime, Integer totalNum, Integer joinNum, String userId,
                     String activityPlace, String activityAddress, String activityType);

    /* *
     * @description: 修改活动信息
     * @params: [activityTitle 活动标题, activityContent 活动内容, activityImage 活动图片, activityStartTime 活动开始时间,
     *  activityEndTime 活动结束时间, activityObject 活动招募对象, recruitStartTime 招募开始时间, recruitEndTime 招募结束时间,
     * totalNum 招募总人数, joinNum 参加人数, studentId 发布人学号, activityPlace 活动地点, activityAddress 详细地点, activityType 活动类型]
     * @return: boolean
     * @author: lazy
     * @dateTime: 2021/3/31 15:42
     */
    boolean updateActivity(String activityId, String activityTitle, String activityContent, String activityStartTime, String activityEndTime,
                       String activityObject, String recruitStartTime, String recruitEndTime, Integer totalNum,
                       Integer joinNum, String activityPlace, String activityAddress, String activityType);



    DetailActivity getDetailActivity(String activityId, String userId);

    /* *
     * @description: 删除活动
     * @params: [activityId 活动id]
     * @return: com.demo.pojo.DetailActivity
     * @author: lazy
     * @dateTime: 2021/3/31 15:41
     */
    boolean deletedActivity(String activityId);

    /* *
     * @description: 查看自己发布的活动
     * @params: [studentId 学号, pageNum 页码]
     * @return: com.demo.pojo.PageResult<com.demo.pojo.MyActivity>
     * @author: lazy
     * @dateTime: 2021/3/31 15:41
     */
    PageResult<MyActivity> getActivityPersonalList(String userId, Integer pageNum);


    /* *
     * @description: 查询活动列表
     * @params: [activityTitle 活动标题, activityObject 招募对象, activityStatus 活动状态, activityPlace 活动地点, pageNum 页码]
     * @return: com.demo.pojo.PageResult<com.demo.pojo.BActivity>
     * @author: lazy
     * @dateTime: 2021/3/29 19:59
     */
    PageResult<BActivity> getActivityList(String activityTitle,
                                          String activityObject,
                                          String activityStatus,
                                          String activityPlace,
                                          Integer pageNum);

}

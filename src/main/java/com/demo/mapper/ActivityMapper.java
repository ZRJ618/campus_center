package com.demo.mapper;

import com.demo.pojo.activity.Activity;
import com.demo.pojo.activity.DetailActivity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ActivityMapper {

    /* *
     * @description: 添加活动信息
     * @params: [activity 活动类]
     * @return: java.lang.Integer
     * @author: lazy
     * @dateTime: 2021/3/31 19:03
     */
    Integer addActivity(Activity activity);

    /* *
     * @description: 获取个人活动列表
     * @params: [studentId 学生id]
     * @return: java.util.List<com.demo.pojo.Activity>
     * @author: lazy
     * @dateTime: 2021/3/31 19:03
     */
    List<Activity> getActivityPersonalList(String userId);


    /* *
     * @description: 根据id获取活动内容
     * @params: [activityId 活动id]
     * @return: com.demo.pojo.Activity
     * @author: lazy
     * @dateTime: 2021/3/31 19:04
     */
    Activity getActivityById(String activityId);

    /* *
     * @description: 通过id获取活动详细信息
     * @params: [activityId]
     * @return: com.demo.pojo.DetailActivity
     * @author: lazy
     * @dateTime: 2021/3/31 19:04
     */
    DetailActivity getDetailActivityById(String activityId);

    /* *
     * @description: 更新活动内容
     * @params: [activity]
     * @return: java.lang.Integer
     * @author: lazy
     * @dateTime: 2021/3/31 19:04
     */
    Integer updateActivity(Activity activity);

    /* *
     * @description: 参与人数加一
     * @params: [activityId]
     * @return: java.lang.Integer
     * @author: lazy
     * @dateTime: 2021/3/31 19:04
     */
    Integer addJoinNum(String activityId, String modifyTime);

    /* *
     * @description: 参与人数减1
     * @params: [activityId]
     * @return: java.lang.Integer
     * @author: lazy
     * @dateTime: 2021/3/31 19:04
     */
    Integer subJoinNum(String activityId, String modifyTime);

    /* *
     * @description: 删除活动
     * @params: [activityId 活动id, modifyTime 修改时间]
     * @return: java.lang.Integer
     * @author: lazy
     * @dateTime: 2021/3/31 19:05
     */
    Integer deleteActivity(String activityId, String modifyTime);



    List<Activity> getActivityList(String activityTitle, String nowDate, String activityStatus,
                                   String activityPlace,String activityObject);
}

package com.demo.mapper;

import com.demo.pojo.activity.Activity;
import com.demo.pojo.activity.JoinActivity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface JoinActivityMapper {

    /* *
     * @description: 参加活动
     * @params: [activity 参加活动类]
     * @return: java.lang.Integer
     * @author: lazy
     * @dateTime: 2021/3/31 19:42
     */
    Integer addJoinInfo(JoinActivity activity);

    /* *
     * @description: 取消参加
     * @params: [activityId 活动id, studentId 学号]
     * @return: java.lang.Integer
     * @author: lazy
     * @dateTime: 2021/3/31 19:43
     */
    Integer deleteJoin(String activityId, String userId);

    /* *
     * @description: 是否参加
     * @params: [activityId 活动id, studentId 学号]
     * @return: com.demo.pojo.JoinActivity
     * @author: lazy
     * @dateTime: 2021/3/31 19:43
     */
    JoinActivity isJoinActivity(String activityId, String userId);

    /* *
     * @description: 获取该用户参加的所有活动
     * @params: [studentId 学号]
     * @return: java.util.List<com.demo.pojo.Activity>
     * @author: lazy
     * @dateTime: 2021/3/31 19:44
     */
    List<Activity> getJoinList(String studentId);
}

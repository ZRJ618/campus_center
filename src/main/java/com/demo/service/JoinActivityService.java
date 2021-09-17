package com.demo.service;

import com.demo.pojo.activity.BActivity;
import com.demo.pojo.PageResult;
import org.springframework.stereotype.Service;

@Service
public interface JoinActivityService {

    /* *
     * @description: 参加活动
     * @params: [userId 用户id, activityId 活动id]
     * @return: boolean
     * @author: lazy
     * @dateTime: 2021/3/31 19:44
     */
    boolean addJoinActivity(String userId, String activityId);

    /* *
     * @description: 取消活动
     * @params: [userId 用户id, activityId 活动id]
     * @return: boolean
     * @author: lazy
     * @dateTime: 2021/3/31 19:44
     */
    boolean cancelJoin(String userId, String activityId);

    /* *
     * @description: 获取个人参加活动列表
     * @params: [userId 用户id, pageNum 页码]
     * @return: com.demo.pojo.PageResult<com.demo.pojo.BActivity>
     * @author: lazy
     * @dateTime: 2021/3/31 19:45
     */
    PageResult<BActivity> getJoinList(String userId, Integer pageNum);
}

package com.demo.pojo.activity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/* *
 * @description: 活动类(对应数据库字段)
 * @author: lazy
 * @dateTime: 2021/3/20 15:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    //活动编号
    private String activityId;
    //活动标题
    private String activityTitle;
    //活动内容
    private String activityContent;
    //活动图片
    private String activityImage;
    //活动开始时间
    private String activityStartTime;
    //活动结束时间
    private String activityEndTime;
    //招募面向对象
    private String activityObject;
    //招募开始时间
    private String recruitStartTime;
    //招募结束时间
    private String recruitEndTime;
    //总招募人数
    private Integer totalNum;
    //参加人数
    private Integer joinNum;
    //发布人学号
    private String userId;
    //发布人姓名
    private String realName;
    //活动地点
    private String activityPlace;
    //具体地点
    private String activityAddress;
    //活动类型
    private String activityType;
    //创建时间
    private String createTime;
    //修改时间
    private String modifyTime;
}

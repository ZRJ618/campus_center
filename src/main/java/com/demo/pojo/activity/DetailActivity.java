package com.demo.pojo.activity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/* *
 * @description: 详细的活动类
 * @author: lazy
 * @dateTime: 2021/3/20 15:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailActivity {
    //活动编号
    private String activityId;
    //活动标题
    private String activityTitle;
    //活动内容
    private String activityContent;
    //活动图片
    private String activityImage;
    //活动状态
    private String activityStatus;

    private List<String> imageList;
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
    private String studentId;
    //发布人真实姓名
    private String userRealName;
    //活动地点
    private String activityPlace;
    //是否已参加
    private boolean isJoin;
}

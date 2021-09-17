package com.demo.pojo.activity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MyActivity {

    //活动id
    private String activityId;
    //发布日期
    private String createTime;
    //活动地址
    private String activityPlace;
    //活动标题
    private String activityTitle;
    //状态
    private String activityStatus;
    //参加人数
    private Integer joinNum;
}

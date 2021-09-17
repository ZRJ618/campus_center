package com.demo.pojo.activity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BActivity {
    //活动id
    private String activityId;
    //活动标题
    private String activityTitle;
    //活动发起人姓名
    private String realName;
    //活动发起时间
    private String createTime;
    //活动状态
    private String activityStatus;
    //活动图片
    private String activityImage;
}

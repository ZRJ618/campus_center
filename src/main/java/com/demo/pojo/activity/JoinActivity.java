package com.demo.pojo.activity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* *
 * @description: 活动表(对应数据库)
 * @author: lazy
 * @dateTime: 2021/3/20 15:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoinActivity {
    //加入活动编号
    private String joinId;
    //学号
    private String userId;
    //活动号
    private String activityId;
    //创建时间
    private String createTime;
    //修改时间
    private String modifyTime;

}

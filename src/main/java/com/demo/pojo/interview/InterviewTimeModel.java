package com.demo.pojo.interview;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/* *
 * @description: 面试时间表(model)
 * @author: lazy
 * @dateTime: 2021/3/20 15:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterviewTimeModel {
    //学号
    private String timeId;
    //面试的部门
    private String departmentName;
    //开始时间
    private String startTime;
    //结束时间
    private String endTime;
}

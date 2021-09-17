package com.demo.pojo.interview;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/* *
 * @description: 面试时间表(对应数据库)
 * @author: lazy
 * @dateTime: 2021/3/20 15:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterviewTime {
    private String timeId;
    //学号
    private String studentId;
    //面试的部门
    private String departmentName;
    //开始时间
    private String startTime;
    //结束时间
    private String endTime;
    //创建时间
    private String createTime;
    //修改时间
    private String modifyTime;
}

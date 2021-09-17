package com.demo.pojo.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/* *
 * @description: 日志表(对应数据库)
 * @author: lazy
 * @dateTime: 2021/3/20 15:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogMessage {
    //执行账号
    private String userId;
    //执行方法
    private String method;
    //执行后的状态
    private String status;
    //执行时间
    private String executionTime;
    //接收的参数
    private String receiveParam;
}

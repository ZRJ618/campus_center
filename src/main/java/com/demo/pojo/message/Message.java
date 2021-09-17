package com.demo.pojo.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/* *
 * @description: 信息响应类
 * @author: lazy
 * @dateTime: 2021/3/20 15:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    //响应信息
    private String msg;
    //响应状态
    private Integer status;
    //响应数据
    private Object data;
}

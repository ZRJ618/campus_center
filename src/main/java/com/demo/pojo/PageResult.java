package com.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/* *
 * @description: 分页类
 * @author: lazy
 * @dateTime: 2021/3/20 15:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    //当前页
    private Integer pageNum;
    //每页记录数
    private Integer size;
    //总记录数
    private Long total;
    //总页数
    private Integer pages;

    private List<T> data;
}

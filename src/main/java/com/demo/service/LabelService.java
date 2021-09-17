package com.demo.service;


import com.demo.pojo.Label;

import java.util.List;

public interface LabelService {
    //查询label的自增Id
    Integer selectSelfAdd(String label);

    //根据自增Id查询label
    String selectLabel(int selfAdd);

    //插入一条记录
    boolean insert(String labe);

    //修改label
    boolean update(String newLabel, String oldLabel);

    //查询所有label
    List<Label> selectAll();
}

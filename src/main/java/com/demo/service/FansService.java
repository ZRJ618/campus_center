package com.demo.service;


import com.demo.pojo.Fans;

import java.util.List;

public interface FansService {
    //关注otherUser
    boolean insertUser(String userId, String fansId);

    //取消关注otherUser
    boolean deleteUser(String userId,String fansId);


    //根据userId与fansId查询数据
    Fans selectByUserIdAndFansId(String userId, String fansId);

    //根据userId查询其关注者总数
    Integer selectFocusNum(String userId);

    //根据userId查询其粉丝总数
    Integer selectFansNum(String userId);

    //根据userId查询其所有关注者
    List<Fans> selectFocus(String userId);

    //分页查询:根据userId查询其所有关注者
    List<Fans> selectFocusByPage(String userId, int offSet, int pageSize);

    //根据userId查询其所有粉丝
    List<Fans> selectFans(String userId);

    //分页查询:根据userId查询其所有粉丝
    List<Fans> selectFansByPage(String userId, int offSet, int pageSize);

}

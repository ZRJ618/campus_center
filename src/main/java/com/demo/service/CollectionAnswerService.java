package com.demo.service;

import com.demo.pojo.CollectionAnswer;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CollectionAnswerService {
    //插入一条记录
    boolean insertCollection(String userId, String answerId);

    //删除一条记录
    boolean updateStatus(String userId, String answerId);

    //根据指定userId查询其所有collectAnswer
    List<CollectionAnswer> selectAllAnswerByUserId(String userId);

    //分页查询:根据指定userId查询其所有collectAnswer
    List<CollectionAnswer> selectAllAnswerByUserIdByPage(@Param("userId") String userId, @Param("offSet") int offSet, @Param("pageSize") int pageSize);


    //根据指定的userId、answerId查找记录
    CollectionAnswer selectAnswerByUserIdAndAnswerId(String userId, String answerId);
}

package com.demo.service;

import com.demo.pojo.CollectionQuestion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectionQuestionService {
    //插入一条记录
    boolean insertCollection(String userId, String questionId);

    //删除一条记录
    boolean updateStatus(String userId, String questionId);

    //根据指定userId查询其所有collectAnswer
    List<CollectionQuestion> selectAllQuestionByUserId(String userId);

    //分页查询:根据指定userId查询其所有collectAnswer
    List<CollectionQuestion> selectAllQuestionByUserIdByPage(@Param("userId") String userId, @Param("offSet") int offSet, @Param("pageSize") int pageSize);


    //根据指定的userId、answerId查找记录
    CollectionQuestion selectQuestionByUserIdAndQuestionId(String userId, String questionId);
}

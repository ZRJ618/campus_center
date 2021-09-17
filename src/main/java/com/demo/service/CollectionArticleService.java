package com.demo.service;

import com.demo.pojo.CollectionArticle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectionArticleService {
    //插入一条记录
    boolean insertCollection(String userId, String articleId);

    //删除一条记录
    boolean updateStatus(String userId, String articleId);

    //根据指定userId查询其所有collectAnswer
    List<CollectionArticle> selectAllArticleByUserId(String userId);

    //分页查询:根据指定userId查询其所有collectAnswer
    List<CollectionArticle> selectAllArticleByUserIdByPage(@Param("userId") String userId, @Param("offSet") int offSet, @Param("pageSize") int pageSize);


    //根据指定的userId、answerId查找记录
    CollectionArticle selectArticleByUserIdAndArticleId(String userId, String articleId);
}

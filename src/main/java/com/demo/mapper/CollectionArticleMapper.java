package com.demo.mapper;

import com.demo.pojo.CollectionArticle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CollectionArticleMapper {
    //插入一条记录
    boolean insertCollection(@Param("userId") String userId, @Param("articleId") String articleId);

    //删除一条记录
    boolean updateStatus(@Param("userId") String userId, @Param("articleId") String articleId);

    //根据指定userId查询其所有collectAnswer
    List<CollectionArticle> selectAllArticleByUserId(@Param("userId") String userId);

    //分页查询:根据指定userId查询其所有collectAnswer
    List<CollectionArticle> selectAllArticleByUserIdByPage(@Param("userId") String userId, @Param("offSet") int offSet, @Param("pageSize") int pageSize);

    //根据指定的userId、answerId查找记录
    CollectionArticle selectArticleByUserIdAndArticleId(@Param("userId") String userId, @Param("articleId") String articleId);
}

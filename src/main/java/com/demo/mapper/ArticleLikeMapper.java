package com.demo.mapper;

import com.demo.pojo.ArticleLike;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ArticleLikeMapper {
    //添加一条记录
    boolean insertArticleLike(@Param("userId") String userId, @Param("articleId") String articleId);

    //删除一条记录
    boolean deleteArticleLike(@Param("userId") String userId, @Param("articleId") String articleId);

    //根据userId与articleId查找记录
    ArticleLike selectByUserIdAndArticleId(@Param("userId") String userId, @Param("articleId") String articleId);
}

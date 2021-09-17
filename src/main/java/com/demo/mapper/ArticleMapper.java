package com.demo.mapper;

import com.demo.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Mapper
@Repository
public interface ArticleMapper {
    //插入文章
    boolean insertArticle(@Param("articleId") String articleId, @Param("userId") String userId, @Param("title") String title, @Param("content") String content,
                          @Param("createTime") Timestamp createTime, @Param("likeNum") int likeNum, @Param("unlikeNum") int unlikeNum,
                          @Param("commentNum") int commentNum, @Param("articleImage") String articleImage, @Param("status") int status);

    //删除指定article的所有label
    boolean deleteArticleLabel(@Param("articleId") String articleId);

    //添加指定article的label
    boolean insertArticleLabel(@Param("articleId") String articleId, @Param("label") int label);

    //根据articleId查询文章
    Article selectArticleById(@Param("articleId") String articleId);

    //修改article
    boolean updateArticle(@Param("articleId") String articleId, @Param("title") String title, @Param("content") String content,
                          @Param("articleCover") String articleCover);

    //根据userId展示所有文章
    List<Article> selectAllArticle(@Param("userId") String userId);

    //查询所有article的articleId
    List<String> selectWholeArticleId();

    //分页查询:根据userId展示所有文章
    List<Article> selectAllArticleByPage(@Param("userId") String userId, @Param("offSet") int offSet, @Param("pageSize") int pageSize);

    //删除某篇article
    boolean deleteArticle(@Param("articleId") String articleId);

    //根据articleId修改其likeNum
    boolean updateLikeNum(@Param("likeNum") int likeNum, @Param("articleId") String articleId);

    //根据articleId修改其scanNum
    boolean updateScanNum(@Param("scanNum") int scanNum, @Param("articleId") String articleId);
}

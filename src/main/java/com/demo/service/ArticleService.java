package com.demo.service;


import com.demo.pojo.Article;

import java.sql.Timestamp;
import java.util.List;

public interface ArticleService {
    //插入文章
    boolean insertArticle(String articleId, String userId, String title, String content, Timestamp createTime,
                          int likeNum, int unlikeNum, int commentNum, String articleImage, int status);

    //删除指定article的所有label
    boolean deleteArticleLabel(String articleId);

    //添加指定article的label
    boolean insertArticleLabel(String articleId, int label);

    //根据articleId查询文章
    Article selectArticleById(String articleId);

    //修改article
    boolean updateArticle(String articleId, String title, String content, String articleCover);

    //根据userId展示所有文章
    List<Article> selectAllArticle(String userId);

    //查询所有article的articleId
    List<String> selectWholeArticleId();

    //分页查询:根据userId展示所有文章
    List<Article> selectAllArticleByPage(String userId, int offSet, int pageSize);

    //删除某篇article
    boolean deleteArticle(String articleId);

    //根据articleId修改其likeNum
    boolean updateLikeNum(int likeNum, String articleId);

    //根据articleId修改其scanNum
    boolean updateScanNum(int scanNum, String articleId);
}

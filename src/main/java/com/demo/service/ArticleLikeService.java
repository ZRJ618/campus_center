package com.demo.service;


import com.demo.pojo.ArticleLike;

public interface ArticleLikeService {
    //添加一条记录
    boolean insertArticleLike(String userId, String articleId);

    //删除一条记录
    boolean deleteArticleLike(String userId, String articleId);

    //根据userId与articleId查找记录
    ArticleLike selectByUserIdAndArticleId(String userId, String articleId);
}

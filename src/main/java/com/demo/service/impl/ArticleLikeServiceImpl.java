package com.demo.service.impl;

import com.demo.mapper.ArticleLikeMapper;
import com.demo.pojo.ArticleLike;
import com.demo.service.ArticleLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleLikeServiceImpl implements ArticleLikeService {
    @Autowired
    ArticleLikeMapper mapper;

    @Override
    public boolean insertArticleLike(String userId, String articleId) {
        return mapper.insertArticleLike(userId,articleId);
    }

    @Override
    public boolean deleteArticleLike(String userId, String articleId) {
        return mapper.deleteArticleLike(userId,articleId);
    }

    @Override
    public ArticleLike selectByUserIdAndArticleId(String userId, String articleId) {
        return mapper.selectByUserIdAndArticleId(userId, articleId);
    }
}

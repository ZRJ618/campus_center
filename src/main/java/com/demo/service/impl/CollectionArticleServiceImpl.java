package com.demo.service.impl;


import com.demo.mapper.CollectionArticleMapper;
import com.demo.pojo.CollectionArticle;
import com.demo.service.CollectionArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionArticleServiceImpl implements CollectionArticleService {
    @Autowired
    CollectionArticleMapper mapper;

    @Override
    public boolean insertCollection(String userId, String articleId) {
        return mapper.insertCollection(userId,articleId);
    }

    @Override
    public boolean updateStatus(String userId, String articleId) {
        return mapper.updateStatus(userId,articleId);
    }

    @Override
    public List<CollectionArticle> selectAllArticleByUserId(String userId) {
        return mapper.selectAllArticleByUserId(userId);
    }

    @Override
    public List<CollectionArticle> selectAllArticleByUserIdByPage(String userId, int offSet, int pageSize) {
        return mapper.selectAllArticleByUserIdByPage(userId, offSet, pageSize);
    }

    @Override
    public CollectionArticle selectArticleByUserIdAndArticleId(String userId, String articleId) {
        return mapper.selectArticleByUserIdAndArticleId(userId,articleId);
    }
}

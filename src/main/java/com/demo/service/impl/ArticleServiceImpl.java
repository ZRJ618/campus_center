package com.demo.service.impl;

import com.demo.mapper.ArticleMapper;
import com.demo.pojo.Article;
import com.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public boolean insertArticle(String articleId, String userId, String title, String content, Timestamp createTime,
                                 int likeNum, int unlikeNum, int commentNum, String articleImage, int status) {
        return articleMapper.insertArticle(articleId, userId, title, content, createTime, likeNum, unlikeNum, commentNum, articleImage, status);
    }

    @Override
    public boolean deleteArticleLabel(String articleId) {
        return articleMapper.deleteArticleLabel(articleId);
    }

    @Override
    public boolean insertArticleLabel(String articleId, int label) {
        return articleMapper.insertArticleLabel(articleId,label);
    }

    @Override
    public Article selectArticleById(String articleId) {
        return articleMapper.selectArticleById(articleId);
    }

    @Override
    public boolean updateArticle(String articleId, String title, String content, String articleCover) {
        return articleMapper.updateArticle(articleId,title,content,articleCover);
    }

    @Override
    public List<Article> selectAllArticle(String userId) {
        return articleMapper.selectAllArticle(userId);
    }

    @Override
    public List<String> selectWholeArticleId() {
        return articleMapper.selectWholeArticleId();
    }

    @Override
    public List<Article> selectAllArticleByPage(String userId, int offSet, int pageSize) {
        return articleMapper.selectAllArticleByPage(userId, offSet, pageSize);
    }

    @Override
    public boolean deleteArticle(String articleId) {
        return articleMapper.deleteArticle(articleId);
    }

    @Override
    public boolean updateLikeNum(int likeNum, String articleId) {
        return articleMapper.updateLikeNum(likeNum,articleId);
    }

    @Override
    public boolean updateScanNum(int scanNum, String articleId) {
        return articleMapper.updateScanNum(scanNum,articleId);
    }
}

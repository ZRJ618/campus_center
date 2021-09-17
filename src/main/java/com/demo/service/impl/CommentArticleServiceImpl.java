package com.demo.service.impl;

import com.demo.mapper.CommentArticleMapper;
import com.demo.pojo.CommentArticle;
import com.demo.service.CommentArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentArticleServiceImpl implements CommentArticleService {
    @Autowired
    CommentArticleMapper mapper;

    @Override
    public boolean insertComment(String commentId, String articleId, String userId, String content, String createTime, int likeNum, int status) {
        return mapper.insertComment(commentId,articleId,userId,content,createTime,likeNum,status);
    }

    @Override
    public boolean updateStatus(String commentId) {
        return mapper.updateStatus(commentId);
    }

    @Override
    public List<CommentArticle> selectAllCommentByArticleId(String articleId) {
        return mapper.selectAllCommentByArticle(articleId);
    }

    @Override
    public List<CommentArticle> selectAllCommentByArticleByPage(String articleId, int offSet, int pageSize) {
        return mapper.selectAllCommentByArticleByPage(articleId, offSet, pageSize);
    }

    @Override
    public CommentArticle selectCommentById(String commentId) {
        return mapper.selectCommentById(commentId);
    }

    @Override
    public boolean updateLikeNum(String commentId, int likeNum) {
        return mapper.updateLikeNum(commentId, likeNum);
    }
}

package com.demo.service.impl;


import com.demo.mapper.CommentAnswerMapper;
import com.demo.pojo.CommentAnswer;
import com.demo.service.CommentAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentAnswerServiceImpl implements CommentAnswerService {
    @Autowired
    CommentAnswerMapper mapper;

    @Override
    public boolean insertComment(String commentId, String answerId, String userId, String content, String createTime, int likeNum, int status) {
        return mapper.insertComment(commentId,answerId,userId,content,createTime,likeNum,status);
    }

    @Override
    public boolean updateStatus(String commentId) {
        return mapper.updateStatus(commentId);
    }

    @Override
    public List<CommentAnswer> selectAllCommentByAnswerId(String answerId) {
        return mapper.selectAllCommentByAnswerId(answerId);
    }

    @Override
    public List<CommentAnswer> selectAllCommentByAnswerIdByPage(String answerId, int offSet, int pageSize) {
        return mapper.selectAllCommentByAnswerIdByPage(answerId, offSet, pageSize);
    }

    @Override
    public CommentAnswer selectCommentById(String commentId) {
        return mapper.selectCommentById(commentId);
    }

    @Override
    public boolean updateLikeNum(String commentId, int likeNum) {
        return mapper.updateLikeNum(commentId,likeNum);
    }
}

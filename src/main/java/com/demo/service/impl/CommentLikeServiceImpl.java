package com.demo.service.impl;


import com.demo.mapper.CommentLikeMapper;
import com.demo.pojo.CommentLike;
import com.demo.service.CommentLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentLikeServiceImpl implements CommentLikeService {
    @Autowired
    CommentLikeMapper mapper;

    @Override
    public CommentLike selectByUserIdAndCommentId(String userId, String commentId) {
        return mapper.selectByUserIdAndCommentId(userId,commentId);
    }

    @Override
    public boolean insertCommentLike(String userId, String commentId) {
        return mapper.insertCommentLike(userId,commentId);
    }
}

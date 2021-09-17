package com.demo.service;


import com.demo.pojo.CommentLike;

public interface CommentLikeService {
    //根据userId与commentId查询记录
    CommentLike selectByUserIdAndCommentId(String userId, String commentId);

    //添加一条记录
    boolean insertCommentLike(String userId, String commentId);
}

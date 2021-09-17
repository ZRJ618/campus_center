package com.demo.service;

import com.demo.pojo.CommentAnswer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentAnswerService {
    //插入一条数据
    boolean insertComment(String commentId, String answerId, String userId, String content,
                          String createTime, int likeNum, int status);

    //根据commentId更改其status
    boolean updateStatus(String commentId);

    //根据answerId查找其所有comment记录
    List<CommentAnswer> selectAllCommentByAnswerId(String answerId);

    //分页查询:根据answerId查找其所有comment记录
    List<CommentAnswer> selectAllCommentByAnswerIdByPage(@Param("answerId") String answerId, @Param("offSet") int offSet, @Param("pageSize") int pageSize);


    //根据commentId查找某条comment
    CommentAnswer selectCommentById(String commentId);

    //根据commentId更改likeNum的值
    boolean updateLikeNum(String commentId, int likeNum);
}

package com.demo.service;

import com.demo.pojo.CommentArticle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentArticleService {
    //插入一条数据
    boolean insertComment(String commentId, String articleId, String userId, String content,
                          String createTime, int likeNum, int status);

    //根据commentId更改其status
    boolean updateStatus(String commentId);

    //根据answerId查找其所有comment记录
    List<CommentArticle> selectAllCommentByArticleId(String articleId);

    //分页查询:根据articleId查找其所有comment记录
    List<CommentArticle> selectAllCommentByArticleByPage(@Param("articleId") String articleId, @Param("offSet") int offSet, @Param("pageSize") int pageSize);

    //根据commentId查找某条comment
    CommentArticle selectCommentById(String commentId);

    //根据commentId更改likeNum的值
    boolean updateLikeNum(String commentId, int likeNum);
}

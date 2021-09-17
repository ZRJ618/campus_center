package com.demo.mapper;

import com.demo.pojo.CommentArticle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentArticleMapper {
    //插入一条数据
    boolean insertComment(@Param("commentId") String commentId, @Param("articleId") String articleId, @Param("userId") String userId,
                          @Param("content") String content, @Param("createTime") String createTime, @Param("likeNum") int likeNum, @Param("status") int status);

    //根据commentId更改其status
    boolean updateStatus(@Param("commentId") String commentId);

    //根据articleId查找其所有comment记录
    List<CommentArticle> selectAllCommentByArticle(@Param("articleId") String articleId);

    //分页查询:根据articleId查找其所有comment记录
    List<CommentArticle> selectAllCommentByArticleByPage(@Param("articleId") String articleId, @Param("offSet") int offSet, @Param("pageSize") int pageSize);

    //根据commentId查找某条comment
    CommentArticle selectCommentById(@Param("commentId") String commentId);

    //根据commentId更改likeNum的值
    boolean updateLikeNum(@Param("commentId") String commentId, @Param("likeNum") int likeNum);
}

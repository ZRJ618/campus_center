package com.demo.mapper;

import com.demo.pojo.CommentLike;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CommentLikeMapper {
    //根据userId与commentId查询记录
    CommentLike selectByUserIdAndCommentId(@Param("userId") String userId, @Param("commentId") String commentId);

    //添加一条记录
    boolean insertCommentLike(@Param("userId") String userId, @Param("commentId") String commentId);
}

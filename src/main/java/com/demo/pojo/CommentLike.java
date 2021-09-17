package com.demo.pojo;

import lombok.Data;

/*
* 该表存放着对评论点赞的记录
* */
@Data
public class CommentLike {
    private String userId;
    private String commentId;
}

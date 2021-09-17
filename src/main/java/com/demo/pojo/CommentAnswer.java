package com.demo.pojo;

import lombok.Data;

@Data
public class CommentAnswer {
    private String commentId;
    private String answerId;
    private String userId;
    private String content;
    private String createTime;//插入时用Timestamp类型
    private int likeNum;
    private int status;
}

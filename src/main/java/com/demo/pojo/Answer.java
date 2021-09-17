package com.demo.pojo;

import lombok.Data;

@Data
public class Answer {
    private String answerId;
    private String questionId;
    private String userId;
    private String content;
    private String createTime;//插入时用Timestamp类型
    private int likeNum;
    private int unlikeNum;
    private int commentNum;
    private int scanNum;
    private int status;
}

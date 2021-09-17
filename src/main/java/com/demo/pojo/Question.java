package com.demo.pojo;

import lombok.Data;

@Data
public class Question {
    private String questionId;
    private String userId;
    private String title;
    private String content;
    private int allAnswerLikeNum;
    private String createTime;//插入时用Timestamp类型
    private String questionImage;//question的封面图片
    private int scanNum;
    private int status;
}

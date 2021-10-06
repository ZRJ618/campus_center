package com.demo.service.resultPojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class SearchServiceResultPojo {
    //question
    private String questionId;
    private String question_title;
    private String question_content;
    private String question_image;//question的封面图片
    private int question_scanNum;
    //answer
    private String answerId;
    private String answer_questionId;
    private String answer_questonTitle;//answer的question的标题
    private String answer_userName;//answer的作者
    private String answer_content;
    private String answer_createTime;//插入时用Timestamp类型
    private int answer_likeNum;
    private int answer_unlikeNum;
    private int answer_commentNum;
}

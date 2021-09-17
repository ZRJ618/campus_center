package com.demo.pojo;

import lombok.Data;

@Data
public class Article {
    private String articleId;
    private String userId;
    private String title;
    private String content;
    private String createTime;//插入时用Timestamp类型
    private int likeNum;
    private int unlikeNum;
    private int commentNum;
    private String articleImage;
    private int scanNum;
    private int status;
}

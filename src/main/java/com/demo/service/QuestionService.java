package com.demo.service;


import com.demo.pojo.Question;

import java.sql.Timestamp;
import java.util.List;

public interface QuestionService {
    //插入question
    boolean insertQuestion(String title, String content, String userId, String questionId, Timestamp createTime, String questionImage, int status);

    //删除指定question的所有label
    boolean deleteQuestionLabel(String questionId);

    //添加指定question的label
    boolean insertQuestionLabel(String questionId, Integer label);

    //修改question
    boolean updateQuestion(String questionId, String title, String content,String questionImage);

    //根据questionId查询question
    Question selectQuestion(String questionId);

    //根据userId查询其所有question（status为1）
    List<Question> selectAllQuestionByUserId(String userId);

    //分页查询:根据userId查询其所有question（status为1）
    List<Question> selectAllQuestionByUserIdByPage(String userId, int offSet, int pageSize);


    //删除某篇question
    boolean deleteQuestion(String questionId);

    //answer的question的总点赞数加一
    boolean updateAllAnswerLikeNum(int allAnswerLikeNum, String questionId);

    //answer的question的总浏览量加一
    boolean updateAllAnswerScanNum(int allAnswerScanNum, String questionId);

    //指定时间之内，按总点赞数进行降序排列，查找所有question（首页）
    List<Question> showHomePage();


}

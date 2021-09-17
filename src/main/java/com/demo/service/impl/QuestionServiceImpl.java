package com.demo.service.impl;


import com.demo.mapper.QuestionMapper;
import com.demo.pojo.Question;
import com.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionMapper questionMapper;

    @Override
    public boolean insertQuestion(String title, String content, String userId, String questionId, Timestamp createTime, String questionImage,int status) {
        return questionMapper.insertQuestion(title,content,userId,questionId,createTime,questionImage,status);
    }

    @Override
    public boolean deleteQuestionLabel(String questionId) {
        return questionMapper.deleteQuestionLabel(questionId);
    }

    @Override
    public boolean insertQuestionLabel(String questionId, Integer label) {
        return questionMapper.insertQuestionLabel(questionId,label);
    }

    @Override
    public boolean updateQuestion(String questionId, String title, String content,String questionImage) {
        return questionMapper.updateQuestion(questionId,title,content,questionImage);
    }

    @Override
    public Question selectQuestion(String questionId) {
        return questionMapper.selectQuestion(questionId);
    }

    @Override
    public List<Question> selectAllQuestionByUserId(String userId) {
        return questionMapper.selectAllQuestionByUserId(userId);
    }

    @Override
    public List<Question> selectAllQuestionByUserIdByPage(String userId, int offSet, int pageSize) {
        return questionMapper.selectAllQuestionByUserIdByPage(userId, offSet, pageSize);
    }

    @Override
    public boolean deleteQuestion(String questionId) {
        return questionMapper.deleteQuestion(questionId);
    }

    @Override
    public boolean updateAllAnswerLikeNum(int allAnswerLikeNum, String questionId) {
        return questionMapper.updateAllAnswerLikeNum(allAnswerLikeNum,questionId);
    }

    @Override
    public boolean updateAllAnswerScanNum(int allAnswerScanNum, String questionId) {
        return questionMapper.updateAllAnswerScanNum(allAnswerScanNum,questionId);
    }

    @Override
    public List<Question> showHomePage() {
        List<Question> pojos = new ArrayList<>();
        //设置timestamp为十天前
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,-10);
        Timestamp timestamp = new Timestamp(calendar.getTime().getTime());
        //操作数据库：十天之内，按照其回答点赞总数排列，最多30条
        return questionMapper.showHomePage(timestamp);
    }
}

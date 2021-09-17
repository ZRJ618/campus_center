package com.demo.service.impl;

import com.demo.mapper.AnswerMapper;
import com.demo.pojo.Answer;
import com.demo.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    AnswerMapper answerMapper;

    @Override
    public boolean insertAnswer(String answerId, String questionId, String userId, String content, Timestamp createTime,
                                int likeNum, int unlikeNum, int commentNum, int status) {
        return answerMapper.insertAnswer(answerId,questionId,userId,content,createTime,likeNum,unlikeNum,commentNum,status);
    }

    @Override
    public Answer selectAnswerById(String answerId) {
        return answerMapper.selectAnswerById(answerId);
    }

    @Override
    public List<Answer> selectAllAnswerByQuestionId(String questionId) {
        return answerMapper.selectAllAnswerByQuestionId(questionId);
    }

    @Override
    public List<Answer> selectAllAnswerByQuestionIdByPage(String questionId, int offSet, int pageSize) {
        return answerMapper.selectAllAnswerByQuestionIdByPage(questionId, offSet, pageSize);
    }

    @Override
    public boolean deleteAnswer(String answerId) {
        return answerMapper.deleteAnswer(answerId);
    }

    @Override
    public List<Answer> selectAllAnswerByUserId(String userId) {
        return answerMapper.selectAllAnswerByUserId(userId);
    }

    @Override
    public List<Answer> selectAllAnswerByUserIdByPage(String userId, int offSet, int pageSize) {
        return answerMapper.selectAllAnswerByUserIdByPage(userId,offSet,pageSize);
    }

    @Override
    public boolean updateContent(String content, String answerId) {
        return answerMapper.updateContent(content,answerId);
    }

    @Override
    public boolean updateLikeNum(int likeNum, String answerId) {
        return answerMapper.updateLikeNum(likeNum,answerId);
    }

    @Override
    public boolean updateScanNum(int scanNum, String answerId) {
        return answerMapper.updateScanNum(scanNum,answerId);
    }
}

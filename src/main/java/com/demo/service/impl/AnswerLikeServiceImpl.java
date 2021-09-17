package com.demo.service.impl;

import com.demo.mapper.AnswerLikeMapper;
import com.demo.pojo.AnswerLike;
import com.demo.service.AnswerLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerLikeServiceImpl implements AnswerLikeService {
    @Autowired
    AnswerLikeMapper answerLikeMapper;

    @Override
    public boolean insertAnswerLike(String userId, String answerId) {
        return answerLikeMapper.insertAnswerLike(userId,answerId);
    }

    @Override
    public boolean deleteAnswerLike(String userId, String answerId) {
        return answerLikeMapper.deleteAnswerLike(userId,answerId);
    }

    @Override
    public AnswerLike selectByUserIdAndAnswerId(String userId, String answerId) {
        return answerLikeMapper.selectByUserIdAndAnswerId(userId,answerId);
    }
}

package com.demo.service.impl;


import com.demo.mapper.CollectionQuestionMapper;
import com.demo.pojo.CollectionQuestion;
import com.demo.service.CollectionQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionQuestionServiceImpl implements CollectionQuestionService {
    @Autowired
    CollectionQuestionMapper mapper;

    @Override
    public boolean insertCollection(String userId, String questionId) {
        return mapper.insertCollection(userId,questionId);
    }

    @Override
    public boolean updateStatus(String userId, String questionId) {
        return mapper.updateStatus(userId,questionId);
    }

    @Override
    public List<CollectionQuestion> selectAllQuestionByUserId(String userId) {
        return mapper.selectAllQuestionByUserId(userId);
    }

    @Override
    public List<CollectionQuestion> selectAllQuestionByUserIdByPage(String userId, int offSet, int pageSize) {
        return mapper.selectAllQuestionByUserIdByPage(userId, offSet, pageSize);
    }

    @Override
    public CollectionQuestion selectQuestionByUserIdAndQuestionId(String userId, String questionId) {
        return mapper.selectQuestionByUserIdAndQuestionId(userId,questionId);
    }
}

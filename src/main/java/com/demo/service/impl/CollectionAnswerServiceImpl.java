package com.demo.service.impl;

import com.demo.mapper.CollectionAnswerMapper;
import com.demo.pojo.CollectionAnswer;
import com.demo.service.CollectionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionAnswerServiceImpl implements CollectionAnswerService {
    @Autowired
    CollectionAnswerMapper mapper;

    @Override
    public boolean insertCollection(String userId, String answerId) {
        return mapper.insertCollection(userId,answerId);
    }

    @Override
    public boolean updateStatus(String userId, String answerId) {
        return mapper.updateStatus(userId,answerId);
    }

    @Override
    public List<CollectionAnswer> selectAllAnswerByUserId(String userId) {
        return mapper.selectAllAnswerByUserId(userId);
    }

    @Override
    public List<CollectionAnswer> selectAllAnswerByUserIdByPage(String userId, int offSet, int pageSize) {
        return mapper.selectAllAnswerByUserIdByPage(userId, offSet, pageSize);
    }

    @Override
    public CollectionAnswer selectAnswerByUserIdAndAnswerId(String userId, String answerId) {
        return mapper.selectAnswerByUserIdAndAnswerId(userId,answerId);
    }
}

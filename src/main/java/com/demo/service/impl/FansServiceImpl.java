package com.demo.service.impl;


import com.demo.mapper.FansMapper;
import com.demo.pojo.Fans;
import com.demo.service.FansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FansServiceImpl implements FansService {
    @Autowired
    FansMapper fansMapper;

    @Override
    public boolean insertUser(String userId, String fansId) {
        return fansMapper.insertUser(userId,fansId);
    }

    @Override
    public boolean deleteUser(String userId, String fansId) {
        return fansMapper.deleteUser(userId,fansId);
    }

    @Override
    public Fans selectByUserIdAndFansId(String userId, String fansId) {
        return fansMapper.selectByUserIdAndFansId(userId,fansId);
    }

    @Override
    public Integer selectFocusNum(String userId) {
        return fansMapper.selectFocusNum(userId);
    }

    @Override
    public Integer selectFansNum(String userId) {
        return fansMapper.selectFansNum(userId);
    }

    @Override
    public List<Fans> selectFocus(String userId) {
        return fansMapper.selectFocus(userId);
    }

    @Override
    public List<Fans> selectFocusByPage(String userId, int offSet, int pageSize) {
        return fansMapper.selectFocusByPage(userId,offSet,pageSize);
    }

    @Override
    public List<Fans> selectFans(String userId) {
        return fansMapper.selectFans(userId);
    }

    @Override
    public List<Fans> selectFansByPage(String userId, int offSet, int pageSize) {
        return fansMapper.selectFansByPage(userId, offSet, pageSize);
    }
}

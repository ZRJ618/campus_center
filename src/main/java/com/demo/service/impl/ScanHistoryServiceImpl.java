package com.demo.service.impl;

import com.demo.mapper.ScanHistoryMapper;
import com.demo.pojo.ScanHistory;
import com.demo.service.ScanHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScanHistoryServiceImpl implements ScanHistoryService {
    @Autowired
    ScanHistoryMapper mapper;

    @Override
    public boolean insertScanHistory(String scanHistoryId, String userId, String articleOrAnswerId, String createTime) {
        return mapper.insertScanHistory(scanHistoryId,userId,articleOrAnswerId,createTime);
    }

    @Override
    public boolean updateStatus(String scanHistoryId) {
        return mapper.updateStatus(scanHistoryId);
    }

    @Override
    public List<ScanHistory> showAllByUserIdLimitTime(String userId, String limitTime) {
        return mapper.showAllByUserIdLimitTime(userId,limitTime);
    }

    @Override
    public List<ScanHistory> showAllByUserIdLimitTimeByPage(String userId, String limitTime, int offSet, int pageSize) {
        return mapper.showAllByUserIdLimitTimeByPage(userId, limitTime, offSet, pageSize);
    }
}

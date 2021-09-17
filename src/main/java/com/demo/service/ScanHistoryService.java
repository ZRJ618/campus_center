package com.demo.service;


import com.demo.pojo.ScanHistory;

import java.util.List;

public interface ScanHistoryService {
    //插入一条记录
    boolean insertScanHistory(String scanHistoryId,  String userId, String articleOrAnswerId, String createTime);

    //根据scanHistoryId删除一条记录
    boolean updateStatus(String scanHistoryId);

    //根据userId展示其十天之内全部的浏览记录
    List<ScanHistory> showAllByUserIdLimitTime(String userId, String limitTime);

    //根据userId展示其三天之内全部的浏览记录
    List<ScanHistory> showAllByUserIdLimitTimeByPage(String userId, String limitTime,
                                                     int offSet, int pageSize);
}

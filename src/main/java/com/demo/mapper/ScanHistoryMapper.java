package com.demo.mapper;

import com.demo.pojo.ScanHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ScanHistoryMapper {
    //插入一条记录
    boolean insertScanHistory(@Param("scanHistoryId") String scanHistoryId, @Param("userId") String userId,
                              @Param("articleOrAnswerId") String articleOrAnswerId, @Param("createTime") String createTime);

    //根据scanHistoryId删除一条记录
    boolean updateStatus(@Param("scanHistoryId") String scanHistoryId);

    //根据userId展示其san天之内全部的浏览记录
    List<ScanHistory> showAllByUserIdLimitTime(@Param("userId") String userId, @Param("limitTime") String limitTime);

    //根据userId展示其三天之内全部的浏览记录
    List<ScanHistory> showAllByUserIdLimitTimeByPage(@Param("userId") String userId, @Param("limitTime") String limitTime,
                                                     @Param("offSet") int offSet, @Param("pageSize") int pageSize);
}

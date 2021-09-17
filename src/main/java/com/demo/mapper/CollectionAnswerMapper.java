package com.demo.mapper;

import com.demo.pojo.CollectionAnswer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CollectionAnswerMapper {
    //插入一条记录
    boolean insertCollection(@Param("userId") String userId, @Param("answerId") String answerId);

    //删除一条记录
    boolean updateStatus(@Param("userId") String userId, @Param("answerId") String answerId);

    //根据指定userId查询其所有collectAnswer
    List<CollectionAnswer> selectAllAnswerByUserId(@Param("userId") String userId);

    //分页查询:根据指定userId查询其所有collectAnswer
    List<CollectionAnswer> selectAllAnswerByUserIdByPage(@Param("userId") String userId, @Param("offSet") int offSet, @Param("pageSize") int pageSize);

    //根据指定的userId、answerId查找记录
    CollectionAnswer selectAnswerByUserIdAndAnswerId(@Param("userId") String userId, @Param("answerId") String answerId);
}

package com.demo.mapper;

import com.demo.pojo.CollectionQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CollectionQuestionMapper {
    //插入一条记录
    boolean insertCollection(@Param("userId") String userId, @Param("questionId") String questionId);

    //删除一条记录
    boolean updateStatus(@Param("userId") String userId, @Param("questionId") String questionId);

    //根据指定userId查询其所有collectAnswer
    List<CollectionQuestion> selectAllQuestionByUserId(@Param("userId") String userId);

    //分页查询:根据指定userId查询其所有collectAnswer
    List<CollectionQuestion> selectAllQuestionByUserIdByPage(@Param("userId") String userId, @Param("offSet") int offSet, @Param("pageSize") int pageSize);

    //根据指定的userId、questionId查找记录
    CollectionQuestion selectQuestionByUserIdAndQuestionId(@Param("userId") String userId, @Param("questionId") String questionId);
}

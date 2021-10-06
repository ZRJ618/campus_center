package com.demo.mapper;
import com.demo.pojo.Answer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Mapper
@Repository
public interface AnswerMapper {
    //插入一篇answer
    boolean insertAnswer(@Param("answerId") String answerId, @Param("questionId") String questionId, @Param("userId") String userId,
                         @Param("content") String content, @Param("createTime") Timestamp createTime, @Param("likeNum") int likeNum,
                         @Param("unlikeNum") int unlikeNum, @Param("commentNum") int commentNum, @Param("status") int status);
    //根据answerId查询answer
    Answer selectAnswerById(@Param("answerId") String answerId);

    //根据questionId查询其所有的answer
    List<Answer> selectAllAnswerByQuestionId(@Param("questionId") String questionId);

    //分页查询：根据questionId查询其answer
    List<Answer> selectAllAnswerByQuestionIdByPage(@Param("questionId") String questionId, @Param("offSet") int offSet, @Param("pageSize") int pageSize);

    //删除某篇answer(且status=1)
    boolean deleteAnswer(@Param("answerId") String answerId);

    //查询某人所有的answer
    List<Answer> selectAllAnswerByUserId(@Param("userId") String userId);

    //分页查询:查询某人所有的answer
    List<Answer> selectAllAnswerByUserIdByPage(@Param("userId") String userId, @Param("offSet") int offSet, @Param("pageSize") int pageSize);

    //根据answerId修改content
    boolean updateContent(@Param("content") String content, @Param("answerId") String answerId);

    //将该answer的点赞数加一
    boolean updateLikeNum(@Param("likeNum") int likeNum, @Param("answerId") String answerId);

    //将该answer的浏览量加一
    boolean updateScanNum(@Param("scanNum") int scanNum, @Param("answerId") String answerId);

    //搜索业务：根据关键词搜索出所有的answer
    List<Answer> SearchByKeyWord(@Param("keyWord") String keyWord, @Param("offSet")int offSet, @Param("pageSize")int pageSize);

}

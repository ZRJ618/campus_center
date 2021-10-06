package com.demo.mapper;

import com.demo.pojo.Answer;
import com.demo.pojo.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Mapper
@Repository
public interface QuestionMapper {
    //插入question
    boolean insertQuestion(@Param("title") String title, @Param("content") String content, @Param("userId") String userId,
                           @Param("questionId") String questionId, @Param("createTime") Timestamp createTime,
                           @Param("questionImage") String questionImage, @Param("status") int status);

    //删除指定question的所有label
    boolean deleteQuestionLabel(@Param("questionId") String questionId);

    //添加指定question的label
    boolean insertQuestionLabel(@Param("questionId") String questionId, @Param("label") Integer label);

    //修改question
    boolean updateQuestion(@Param("questionId") String questionId, @Param("title") String title, @Param("content") String content, @Param("questionImage") String questionImage);

    //根据questionId查询question
    Question selectQuestion(@Param("questionId") String questionId);

    //根据userId查询其所有question（status为1）
    List<Question> selectAllQuestionByUserId(@Param("userId") String userId);

    //分页查询:根据userId查询其所有question（status为1）
    List<Question> selectAllQuestionByUserIdByPage(@Param("userId") String userId, @Param("offSet") int offSet, @Param("pageSize") int pageSize);

    //删除某篇question
    boolean deleteQuestion(@Param("questionId") String questionId);

    //answer的question的总点赞数加一
    boolean updateAllAnswerLikeNum(@Param("allAnswerLikeNum") int allAnswerLikeNum, @Param("questionId") String questionId);

    //answer的question的总浏览量加一
    boolean updateAllAnswerScanNum(@Param("allAnswerScanNum") int allAnswerScanNum, @Param("questionId") String questionId);


    //指定时间之内，按总点赞数进行降序排列，查找所有question（首页）
    List<Question> showHomePage(@Param("timestamp") Timestamp timestamp);

    //搜索业务：根据关键词搜索出所有的question
    List<Question> SearchByKeyWord(@Param("keyWord") String keyWord, @Param("offSet")int offSet, @Param("pageSize")int pageSize);

}

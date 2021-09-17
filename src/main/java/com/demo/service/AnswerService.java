package com.demo.service;


import com.demo.pojo.Answer;

import java.sql.Timestamp;
import java.util.List;

public interface AnswerService {

    //插入一篇answer
    boolean insertAnswer(String answerId, String questionId, String userId,
                         String content, Timestamp createTime, int likeNum,
                         int unlikeNum, int commentNum, int status);

    //根据answerId查询answer
    Answer selectAnswerById(String answerId);

    //根据questionId查询其所有的answer
    List<Answer> selectAllAnswerByQuestionId(String questionId);

    //分页查询：根据questionId查询其answer
    List<Answer> selectAllAnswerByQuestionIdByPage(String questionId, int offSet, int pageSize);

    //删除某篇answer
    boolean deleteAnswer(String answerId);

    //查询某人所有的answer
    List<Answer> selectAllAnswerByUserId(String userId);

    //分页查询:查询某人所有的answer
    List<Answer> selectAllAnswerByUserIdByPage(String userId, int offSet, int pageSize);


    //根据answerId修改content
    boolean updateContent(String content, String answerId);

    //将该answer的点赞数加一
    boolean updateLikeNum(int likeNum, String answerId);

    //将该answer的点赞数加一
    boolean updateScanNum(int scanNum, String answerId);


}

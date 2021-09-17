package com.demo.service;


import com.demo.pojo.AnswerLike;

public interface AnswerLikeService {
    //添加一条记录
    boolean insertAnswerLike(String userId, String answerId);

    //删除一条记录
    boolean deleteAnswerLike(String userId, String answerId);

    //根据userId与answerId查找记录
    AnswerLike selectByUserIdAndAnswerId(String userId, String answerId);
}

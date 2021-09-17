package com.demo.cache;

import com.demo.pojo.Question;
import com.demo.service.QuestionService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/*
* 使用springCache完成
* */
@Component
@CacheConfig(cacheNames = "HomePageCache")
public class HomePageCache {
    @Autowired
    QuestionService questionService;


    @Cacheable(key = "#root.methodName")
    public List<HomePage2Pojo> homePage2(){
        //操作数据库：十天之内，按照其回答点赞总数排列，最多30条
        List<Question> questions = questionService.showHomePage();
        //筛选返回内容
        List<HomePage2Pojo> pojos = new ArrayList<>();
        questions.forEach( question -> {
            HomePage2Pojo pojo = new HomePage2Pojo();
            pojo.setQuestionId(question.getQuestionId());
            pojo.setTitle(question.getTitle());
            pojo.setAllAnswerLikeNum(question.getAllAnswerLikeNum());
            pojo.setCreateTime(question.getCreateTime());
            pojo.setQuestionImage(question.getQuestionImage());
            pojo.setUserId(question.getUserId());
            pojo.setContent(question.getContent());
            pojo.setScanNum(question.getScanNum());
            pojos.add(pojo);
        });
        return pojos;
    }

    @Data
    public class HomePage2Pojo{
        String questionId;
        String userId;
        String content;
        int scanNum;
        String title;
        int allAnswerLikeNum;
        String createTime;
        String questionImage;
    }
}

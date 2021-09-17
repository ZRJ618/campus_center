package com.demo.cache;

import com.demo.exception.ResultBody;
import com.demo.pojo.Answer;
import com.demo.pojo.CollectionAnswer;
import com.demo.pojo.CommentAnswer;
import com.demo.pojo.CommentLike;
import com.demo.service.AnswerService;
import com.demo.service.CollectionAnswerService;
import com.demo.service.CommentAnswerService;
import com.demo.service.CommentLikeService;
import com.demo.util.DateUtils;
import com.demo.util.PageUtils;
import com.demo.util.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;



/*
* 直接用redisTesmplate完成
* */
@Component
public class CollectionAnswerCache {
    @Autowired
    CollectionAnswerService service;

    @Autowired
    AnswerService answerService;

    @Autowired
    RedisTemplate<String,Object> redisTemplate;


    /*
     * 收藏answer
     * 修改showCollectionAnswer()的缓存
     * */
    public boolean CollectionAnswer(String answerId, HttpServletRequest request) throws NoSuchMethodException {
        String userId = ParamUtil.getUserId(request);
        //判断是否已经收藏过了
        CollectionAnswer collectionAnswer = service.selectAnswerByUserIdAndAnswerId(userId,answerId);
        if(collectionAnswer != null){
            return false;
        }
        if (service.insertCollection(userId,answerId) == true) {
            //修改缓存
            List<CollectionAnswer> collectionAnswers = service.selectAllAnswerByUserId(userId);
            List<Answer> answers = new ArrayList<>();
            for (int i = 0; i < collectionAnswers.size(); i++) {
                Answer answer = answerService.selectAnswerById(collectionAnswers.get(i).getAnswerId());
                answers.add(answer);
            }
            String key = this.getClass().getName()+"::"+this.getClass().getDeclaredMethod("showCollectionAnswer", String.class).getName()+"_"+userId.toString();
            redisTemplate.opsForValue().set(key,answers,24, TimeUnit.HOURS);
            return true;
        }
        return false;
    }


    /*
     * 删除收藏的answer
     * 修改showCollectionAnswer()的缓存
     * */
    public boolean deleteCollctionAnswer(String answerId, HttpServletRequest request) throws NoSuchMethodException {
        String userId = ParamUtil.getUserId(request);
        if (service.updateStatus(userId,answerId) == true) {
            //修改缓存
            List<CollectionAnswer> collectionAnswers = service.selectAllAnswerByUserId(userId);
            List<Answer> answers = new ArrayList<>();
            for (int i = 0; i < collectionAnswers.size(); i++) {
                Answer answer = answerService.selectAnswerById(collectionAnswers.get(i).getAnswerId());
                answers.add(answer);
            }
            String key = this.getClass().getName()+"::"+this.getClass().getDeclaredMethod("showCollectionAnswer", String.class).getName()+"_"+userId.toString();
            redisTemplate.opsForValue().set(key,answers,24, TimeUnit.HOURS);
            return true;
        }
        return false;
    }


    /*
     * 展示某人收藏的answer
     * */
    public List<Answer> showCollectionAnswer(String userId) throws NoSuchMethodException {
        //查询缓存
        String key = this.getClass().getName()+"::"+this.getClass().getDeclaredMethod("showCollectionAnswer", String.class).getName()+"_"+userId.toString();
        List<Answer> list = (List<Answer>) redisTemplate.opsForValue().get(key);
        if (list != null) {
            return list;
        }
        //查询数据库
        List<CollectionAnswer> collectionAnswers = service.selectAllAnswerByUserId(userId);
        List<Answer> answers = new ArrayList<>();
        for (int i = 0; i < collectionAnswers.size(); i++) {
            Answer answer = answerService.selectAnswerById(collectionAnswers.get(i).getAnswerId());
            answers.add(answer);
        }
        //添加缓存
        redisTemplate.opsForValue().set(key,answers,24, TimeUnit.HOURS);
        return answers;
    }


}
